All credit to this @mkotsur [blog post](https://medium.com/@mkotsur/this-is-why-you-should-consider-using-aws-lambda-scala-6b3ea841f8b0).

I was looking for a way to use Scala for AWS Lambda in a more Scala way
than the annotated POJO wrapper approach.  The above blog post showed me the way...

Solution based on https://github.com/mkotsur/aws-lambda-scala.

```console
sbt assembly
sls deploy
sls invoke -f hello --data '{"key1":"it works!", "key2":"wow", "key3":"hiyA"}'
```
