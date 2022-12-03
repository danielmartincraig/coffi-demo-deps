# coffi-demo-deps

This app demos calling native code from Clojure, using the excellent Coffi library found at https://github.com/IGJoshua/coffi

## Installation

Download from https://github.com/danielmartincraig/coffi-demo-deps

## Usage

This application uses the native strlen function from the standard c library to count the strlen of a user-provided string.

Run the project directly, via `:exec-fn`:

    $ clojure -X:run-x
    The length of the input string "Clojure" is: 7

Run the project, overriding the string to be strlen'd:

    $ clojure -X:run-x :user-input '"Hello World"'
    The length of the input string "Hello World" is: 11

Run the project directly, via `:main-opts` (`-m danielmartincraig.coffi-demo-deps`):

    $ clojure -M:run-m "Hello World"
    The length of the input string "Hello World" is: 11

Run the project's tests:

    $ clojure -T:build test

Run the project's CI pipeline and build an uberjar:

    $ clojure -T:build ci

This will produce an updated `pom.xml` file with synchronized dependencies inside the `META-INF`
directory inside `target/classes` and the uberjar in `target`. You can update the version (and SCM tag)
information in generated `pom.xml` by updating `build.clj`.

If you don't want the `pom.xml` file in your project, you can remove it. The `ci` task will
still generate a minimal `pom.xml` as part of the `uber` task, unless you remove `version`
from `build.clj`.

Run that uberjar:

    $ java -jar --add-modules=jdk.incubator.foreign --enable-native-access=ALL-UNNAMED target/coffi-demo-deps-0.1.0-SNAPSHOT.jar "Hello World"

If you remove `version` from `build.clj`, the uberjar will become `target/coffi-demo-deps-standalone.jar`.

## License

Copyright © 2022 Daniel Craig

Distributed under the Eclipse Public License version 1.0.
