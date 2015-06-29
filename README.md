# colored-reporter

An alternative reporter for cljs.test using colors.

## installation

`[colored-reporter "0.3.0-SNAPSHOT"]`

`$ npm install colors@1.1.2`

## use

```clojure
(:require [cljs.test :refer-macros [run-tests]]
          [colored-reporter.core])

(run-tests
  (cljs.test/empty-env :colored-reporter.core/colors)
  'foo.bar)
```
