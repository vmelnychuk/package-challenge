## Quick Start

```shell
./gradlew clean build
java -jar build/libs/package-challenge.jar input-example.txt
```

## Package
Each `thing` you put inside the package has such parameters as `index number`, `weight` and `cost`.

thing:
- index number
- weight
- cost

package

The package has a `weight limit`.
Your goal is to determine which things to put into the package so that the
total weight is less than or equal to the package limit and the total cost is as large as possible.


## General Information
This is example of **0-1 knapsack problem**.
Some assumptions:
- weight > 0
- cost > 0

