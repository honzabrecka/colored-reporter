# colored-reporter

An alternative reporter for cljs.test using colors.

![preview output](https://dl.dropboxusercontent.com/u/75480155/colored-reporter.png)

## Installation

The easiest way is to keep colored-reporter as a dependency in your project.clj:

[![Clojars Project](http://clojars.org/colored-reporter/latest-version.svg)](http://clojars.org/colored-reporter)

To colorize the output, you have to install [colors](https://www.npmjs.com/package/colors). You can simply do it by:

```
npm install colors@1.1.2 --save-dev
```

## Use

```clojure
(:require [cljs.test :refer-macros [run-tests]]
          [jx.reporter.colored])

(run-tests
  (cljs.test/empty-env :jx.reporter.colored/colored)
  'foo.bar)
```
