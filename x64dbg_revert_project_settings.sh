#!/bin/bash

# Visual Studio Software Development Kit Version v143 for VS2022
VS_SDK_VER=v143;

# Changing the versions in all vcxproj files
sed -i "s/$VS_SDK_VER/v120_xp/g" src/bridge/x64dbg_bridge.vcxproj
sed -i "s/$VS_SDK_VER/v120_xp/g" src/dbg/x64dbg_dbg.vcxproj
sed -i "s/$VS_SDK_VER/v120_xp/g" src/exe/x64dbg_exe.vcxproj
sed -i "s/$VS_SDK_VER/v120_xp/g" src/gui/Src/Gui/LogView.cpp
sed -i "s/$VS_SDK_VER/v120_xp/g" src/gui/Src/Gui/LogView.h
sed -i "s/$VS_SDK_VER/v120_xp/g" src/launcher/x64dbg_launcher.vcxproj
sed -i "s/$VS_SDK_VER/v120_xp/g" src/loaddll/loaddll.vcxproj
sed -i "s/$VS_SDK_VER/v120_xp/g" src/zydis_wrapper/zydis_wrapper.vcxproj
# Updating the submodules, to clone the modules from x64dbg repo
sed -i "s/https:\/\/github.com\/x64dbg/\.\./g" .gitmodules
