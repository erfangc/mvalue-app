#!/usr/bin/env bash

SUB_MODULE_DIR="../mvalue-ui"
DEST_DIR="src/main/resources/static"
OLD_PWD=`pwd`

if [[ ! -d "$SUB_MODULE_DIR" ]]; then
    echo -e "$SUB_MODULE_DIR does not exist, please clone the front-end project into an adjacent directory"
    exit 1
fi

cd ${SUB_MODULE_DIR}
npm install
npm run dist

cd ${OLD_PWD}
cp -r ${SUB_MODULE_DIR}/dist/* ${DEST_DIR}

if [[ "$?" ]]; then
    echo -e "Successfully built and copied the web front-end to $DEST_DIR"
fi
