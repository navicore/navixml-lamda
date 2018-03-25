all credit to https://medium.com/@mkotsur/this-is-why-you-should-consider-using-aws-lambda-scala-6b3ea841f8b0

based on https://github.com/mkotsur/aws-lambda-scala

```console
sbt assembly
sls deploy
sls invoke -f hello --data '{"key1":"it works!", "key2":"wow", "key3":"hiyA"}'
```
