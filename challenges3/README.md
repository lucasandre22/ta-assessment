# Test Automation Training

## 3rd Challenge:

### Java project configuration

**Use the archetype to create the project:**  
*mvn archetype:generate -DarchetypeGroupId=org.apache.maven.archetypes -DarchetypeArtifactId=maven-archetype-simple -DarchetypeVersion=1.4*  

>groupId: org.ta.assessment
artifactId: first-challenge  
version: 0.0.1-SNAPSHOT  
package: org.ta.assessment

Use log4j with this log pattern: *[%d{yyyy-MM-dd HH:mm:ss}] [%-5p] [%c{1}:%L] - %m%n*

### Solve the problem below:

As a user, I want to the total Like-to-time coefficient to be maximum for the dishes.
1. I want to be able remove some dishes, in which case, a new coefficient is calculated using the left dishes.
2. The solution must calculate the maximum sum of all possible Like-to-time coefficients.
3. Like-to-time coefficient is calculated with the algoritm below:  
*V[] = {X1, X2 ... XN}  
coefficient = X1*1 + X2*2 + ... + XN*N

**Input Specification:**
input: Array representing the linking value of each dish

**Output Specification:**
Return maximum like-to-time coefficient possible

**Acceptance Criteria:**
1. Check that solution returns the correct coefficient for a valid input of dishes
2. Check the solution when a dish must be removed and when no one is removed

Examples:

Not Removed:
input: {-1,3,4}
Output: 17

Removed:
input: {-1,-9,0,5,-7} #Dish -9 and -7 must be removed
Output: 14

## Class usage
Save your class as challenges3/LikeToTimeDishes.java

Example of usage:
```java
int input = {1, 2, 3};
LikeToTimeDishes likeToTimeDishes = new LikeToTimeDishes();

likeToTimeDishes.calculateSolution(input);
Solution solution = input.getSolution();
System.out.println(solution);

/**
/* Shows:
 * Solution{
 * preparedDishes={1, 2, 3}
 * preparedDishesSize=3
 * coefficient=14
 */
```

## Push your changes to your own branch
git checkout -b thirdchallenge/\<firstname.lastname\>
