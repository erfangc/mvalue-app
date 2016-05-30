#!/usr/bin/env bash

SUB_MODULE_DIR="mvalue-ui"
OLD_PWD=`pwd`
cd ${SUB_MODULE_DIR}
npm install
npm run dist

cd ${OLD_PWD}
cp -r ${SUB_MODULE_DIR}/dist/* src/main/resources/static
