#!/bin/sh
USER_ID=${LOCAL_USER_ID:-9001}
useradd -Ums /bin/sh -u $USER_ID -o -c "" -m dev
export HOME=/home/dev
mkdir -p /home/dev/.m2
chown -R dev:dev $HOME
exec /usr/local/bin/gosu dev "$@"

