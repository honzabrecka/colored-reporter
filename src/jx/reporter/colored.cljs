(ns jx.reporter.colored
  (:require [cljs.nodejs :as node]
            [cljs.test]))

(def colors (node/require "colors"))

(defn exit! [code]
  (.exit node/process code))

(defn testing-vars-str []
  (let [var-meta (meta (nth (:testing-vars (cljs.test/get-current-env)) 0))]
    (str (.yellow colors (:ns var-meta)) "/"
         (.yellow colors (:name var-meta))
         " ("  (:file var-meta) ")")))

(defn print-formated! [type m]
  (println (.red colors type) "in" (testing-vars-str))
  (println (.yellow colors "expected:") (pr-str (:expected m)))
  (println (.yellow colors "  actual:") (pr-str (:actual m)))
  (println ""))

(defn format-summary [m]
  (str "fail: " (:fail m)
       ", error: " (:error m)
       ", pass: " (:pass m)
       " (tests run: " (:test m) ")"))

(defmethod cljs.test/report :colored [m])

(defmethod cljs.test/report [::colored :pass] [m]
  (cljs.test/inc-report-counter! :pass))

(defmethod cljs.test/report [::colored :fail] [m]
  (cljs.test/inc-report-counter! :fail)
  (print-formated! "FAIL" m))

(defmethod cljs.test/report [::colored :error] [m]
  (cljs.test/inc-report-counter! :error)
  (print-formated! "ERROR" m))

(defmethod cljs.test/report [::colored :end-run-tests] [m]
  (if (cljs.test/successful? m)
    (do (println (.green colors "OK!")
                 (format-summary m))
        (exit! 0))
    (do (println (.red colors "FAILED!")
                 (format-summary m))
        (exit! 1))))
