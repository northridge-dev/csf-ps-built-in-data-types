#!/bin/bash

echo "Setting up assignment repository..."


# Navigate to root directory
cd ${0%/*}

# git configuration
if git rev-parse --is-inside-work-tree >/dev/null 2>&1; then
    echo "Git repository detected. Setting up solution branch..."
    
    # Check if solution branch exists
    if git show-ref --verify --quiet refs/heads/solution; then
        echo "'solution' branch already exists. Switching to it."
        git checkout solution
    else
        echo "Creating 'solution' branch..."
        git checkout -b solution
    fi
else
    echo "Not a git repository. Skipping git setup."
fi

# Download JUnit Platform Console Standalone
JUNIT_VERSION="1.13.3"
mkdir -p lib
curl -L -o lib/junit-platform-console-standalone.jar execute https://repo1.maven.org/maven2/org/junit/platform/junit-platform-console-standalone/$JUNIT_VERSION/junit-platform-console-standalone-$JUNIT_VERSION.jar