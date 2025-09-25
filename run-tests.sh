#!/bin/bash
set -e

mkdir -p bin

echo "Compiling..."
javac -cp lib/junit-platform-console-standalone.jar -d bin src/*.java tests/*.java

echo "Running tests..."
java -jar lib/junit-platform-console-standalone.jar \
  --class-path bin \
  --scan-class-path \
  --reports-dir test-results
