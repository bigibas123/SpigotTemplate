#!/usr/bin/env bash
cp /Y ../target/*-SNAPSHOT.jar ./plugins/
java -Xmx1G -Xms1G -jar spigot-*.jar nogui