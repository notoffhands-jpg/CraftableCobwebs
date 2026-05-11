#!/usr/bin/env bash
# Builds build/CobwebRecipes-1.0.jar against the test server's Paper libraries.
set -e
cd "$(dirname "$0")"
LIBS="$HOME/.local/share/botsystem-tools/testserver/libraries"
CP=$(find "$LIBS" -name "*.jar" | tr '\n' ':')
rm -rf build && mkdir -p build/classes
javac --release 21 -nowarn -encoding UTF-8 -cp "$CP" -d build/classes $(find src/main/java -name "*.java")
cp -r src/main/resources/. build/classes/
(cd build/classes && jar --create --file ../CobwebRecipes-1.0.jar .)
echo "Built build/CobwebRecipes-1.0.jar"
