#!/bin/bash
echo "Should be un after building the project in Visual Studio with sln file.\n"
cp -rf deps/x64/* bin/x64/
cp -rf deps/x64d/* bin/x64d/
cp -rf deps/x32/* bin/x32/
cp -rf deps/x32d/* bin/x32d/
echo "Now, replace the Qt*.dll with the actual dlls from your Qt directory"
