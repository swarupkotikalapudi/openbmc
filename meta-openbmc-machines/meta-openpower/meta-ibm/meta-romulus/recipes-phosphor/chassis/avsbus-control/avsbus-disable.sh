#!/bin/sh

i2cset -y 4 0x71 0x01 0x80 b    # VDD 0
i2cset -y 4 0x71 0x00 0x01 b    # VCS 0  - PAGE set
i2cset -y 4 0x71 0x01 0x80 b    # VCS 0
i2cset -y 4 0x71 0x00 0x00 b    # VCS 0  - PAGE reset
i2cset -y 4 0x72 0x01 0x80 b    # VDN 0
i2cset -y 5 0x71 0x01 0x80 b    # VDD 1
i2cset -y 5 0x71 0x00 0x01 b    # VCS 1  - PAGE set
i2cset -y 5 0x71 0x01 0x80 b    # VCS 1
i2cset -y 5 0x71 0x00 0x00 b    # VCS 1  - PAGE reset
i2cset -y 5 0x72 0x01 0x80 b    # VDN 1
