# colored-reporter

An alternative reporter for cljs.test using colors.

## installation

`[colored-reporter "0.3.0-SNAPSHOT"]`

`$ npm install colors@1.1.2`

## use

```clojure
(:require [cljs.test :refer-macros [run-tests]]
          [jx.reporter.colored])

(run-tests
  (cljs.test/empty-env :jx.reporter.colored/colored)
  'foo.bar)
```
