#!/bin/bash

echo "Setting up assignment repository..."

# Navigate to root directory
cd ${0%/*}

# Download JUnit Platform Console Standalone
JUNIT_VERSION="1.13.4"
mkdir -p lib
curl -L -o lib/junit-platform-console-standalone.jar https://repo1.maven.org/maven2/org/junit/platform/junit-platform-console-standalone/$JUNIT_VERSION/junit-platform-console-standalone-$JUNIT_VERSION.jar

