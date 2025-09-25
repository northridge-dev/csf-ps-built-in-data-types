# Problem Set: Built-in Data Types

## How To ...

### Develop Solutions

1. **Write** your Java programs:

   - in the corresponding `.java` file in the `src` directory

2. **Compile** your source code using the `javac` compiler.

   - The general pattern for the command is: `javac path/to/FileName.java`
   - For example, to compile `RightTriangle.java` from the root directory:
     `javac src/RightTriangle.java`.
   - If your program successfully compiles, a new file will be created, for
     example, `RightTriangle.class` or `GreatCircle.class`.
   - If your program does not compile, use the error messages to correct your
     program and try again.
   - Note: If you first `cd` (change directory) to the `src` directory (by
     running `cd src`), you may omit the `src/` path in the example command.

3. **Run** your compiled program with the `java` runtime.

   - The general pattern for the command is: `java -cp path/to FileName <args>`.
   - For example, to run `RightTriangle.class` from the root directory with
     arguments: `java -cp src RightTriangle 3 4 5`

4. **Test** your program.

   - Try different inputs. If you don't get the outputs you expect, debug,
     change the source code, re-compile, and test it again. Keep going until
     your meets the [specifications](#specs).
   - Often a program will work for the most obvious possible inputs but will
     produce the wrong outputs for other, less obvious inputs. A good developer
     will look for these "corner-cases" and make sure his program handles them
     properly.

### Run Graded Tests

1. Once you think you're programs meet the specifications, **run the graded
   tests**:
   - Command to execute from the root directory: `./run-tests.sh`.
   - `run-tests.sh` is a Bash script that will try to compile your programs and
     run them against tests defined in the `tests` directory.
   - You'll see results in the terminal. Results will also be written to the
     `test-results` directory.
2. Repeat?
   - You can run graded tests as many times as you need to. Getting it right on
     the tenth try counts just as much as getting it right on the first try.
   - Use the test output to identify where your program fails to meet the
     specifications.
   - You can also submit a problem set with failing tests. Partial credit will
     be given.

### Submit your Problem Set

0. NOTE: when you first launched your Codespace, a script ran and (among other
   things) created a _branch_ called `solution`. That's the branch you've been
   working on.
1. **Stage** your changes: `git add .` from the root directory. (You can also
   use the VS Code source control tool.)
2. **Commit** your changes with a commit message:
   `git commit -m "completed problem set"`
3. **Push** your changes to your repository: `git push origin solution`.
4. Navigate to your assignment repository and **open a pull request**.
   - Opening a pull request lets me know your problem set is ready to be graded.
   - For this problem set, you're not required to write a pull request
     description, but you may use the space to leave me any notes or ask
     questions.
   - The pull request also gives me a way to leave feedback on your code.

## Specs

Complete each of the following problems. For all problems in this set:

- DO NOT use any control flow statements we have not yet covered (e.g., no `if`,
  `for`, or `while` statements).
- DO NOT use any external libraries or packages.

### RightTriangle.java (booleans and integers)

Write a Java program that accepts three **positive** integers as command line
arguments and determines whether they can form the sides of a right triangle.
The program should print `true` if they can and `false` otherwise.

Recall that all right triangles have sides such that the square of the length of
the longest side is equal to the sum of the squares of the lengths of the other
two sides. (That's the Pythagorean theorem, often algebraically expressed as
$c^2 = a^2 + b^2$ , where $c$ is the longest side.)

For example: Input: `3 4 5` Output: `true`

Input: `1 2 3` Output: `false`

Input: `4 5 3` Output: `true`

Input: `-4, 5 -3` Output: `false`

Input: `13 12 5` Output: `true`

### GreatCircle.java (floating-point numbers and the Java `Math` library)

You can calculate the **great-circle distance** (the shortest distance) between
two points on the surface of a sphere using the following formula:

$$
\text{distance} = 2r \arcsin\left(
    \sqrt{
        \sin^2\left(\frac{x_2 - x_1}{2}\right)
        + \cos(x_1)\cos(x_2)\sin^2\left(\frac{y_2 - y_1}{2}\right)
    }
\right)
$$

Earth is sphere-like enough to use this formula to calculate the distance
between two points on its surface.

Write a Java program that accepts four command line arguments representing the
latitude and longitude of two points on the surface of a sphere (in degrees) and
prints the great-circle distance between them in kilometers. Assume the radius
of the sphere is 6,371 km.

HINT: While the command line arguments will be given in degrees,
[Java's trigonometric functions](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/lang/Math.html)
use radians. Use `Math.toRadians()` to convert from degrees to radians.

Input: `42.02 87.8 41.9 -12.48` (Niles, IL to Rome) Output:
`7740.605988456187 kilometers`

Input: `60.0 15.0 120.0 105.0` Output: `4604.53989281927 kilometers`

### RGBfromCMYK.java (type conversion)

The _RGB format_ (used for many monitors, cameras, and webpages) specifies a
color by the level of **R**ed, **G**reen, and **B**lue as integers from 0
to 255.

The _CMYK format_ (commonly used for printed materials) specifies a color by the
level of **C**yan, **M**agenta, **Y**ellow, and blac**K** as real numbers from
0.0 to 1.0.

Write a Java program that converts from CMYK format to RGB format using the
following formulas:

```
white = 1 - black
red = 255 * white * (1 - cyan)
green = 255 * white * (1 - magenta)
blue = 255 * white * (1 - yellow)
```

Your program must take four `double` command-line arguments specifying (in
order) the level of cyan, magenta, yellow, and black; compute the corresponding
RGB values, **each rounded to the nearest integer**, and print the RGB values as
shown, below (note the spacing!):

Input: `0.0 1.0 0.0 0.0` (magenta) Output:

```
red   = 255
green = 0
blue  = 255
```

Input: `0.0 0.1843 0.698 0.0` (Northridge gold) Output:

```
red   = 255
green = 208
blue  = 77
```

## Acknowledgements

This problem set is drawn from Robert Sedgewick's and Kevin Wayne's excellent
Coursera course,
[Computer Science: Programming with a Purpose](https://www.coursera.org/learn/cs-programming-java).
