# scala-vs-twitter-future
A brief comparison on behavior between Scala Futures and Twitter Futures on fatal exceptions.

**Summary**
* Scala Future: Fatal exceptions will cause the future to hang. Any awaits on a composition of Scala Futures that involve a fatal exception like a `NonLocalReturnException` or `LinkageError` will never complete.
* Twitter Future: Fatal exceptions will cause the future to be completed exceptionally (Similar to a Java CompletableFuture).
