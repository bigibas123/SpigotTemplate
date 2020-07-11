#!/usr/bin/env bash
cp -fv ../target/*-SNAPSHOT.jar ./plugins/
java -Xmx1G -Xms1G -jar spigot-*.jar nogui