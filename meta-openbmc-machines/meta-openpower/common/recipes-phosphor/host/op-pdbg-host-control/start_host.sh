#!/bin/sh

# send putcfam command to have SBE start IPL
pdbg-p9 -b fsi putcfam 0x2801 0x80000000 0x80000000
