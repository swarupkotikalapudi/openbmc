# OpenBMC #

[![Build Status](https://openpower.xyz/buildStatus/icon?job=openbmc-build)](https://openpower.xyz/job/openbmc-build/)

The OpenBMC project can be descibed as a Linux distribution for embedded
devices focused on server management.  This embedded Base Management
Controller stack uses technologies such as Yocto, Open-Embedded, Systemd and
DBus to allow easy customization for your server platform.


## Setting up your OpenBMC project ##

### 1) Prerequisite ###
This steps is just to get the required host packages on to your system.
You only need to do this step once...

- Ubuntu 14.04

```
sudo apt-get install -y git build-essential libsdl1.2-dev texinfo gawk chrpath diffstat
```

- Fedora 23

```
sudo dnf install -y git patch diffstat texinfo chrpath SDL-devel bitbake
sudo dnf groupinstall "C Development Tools and Libraries"
```

### 2) Target your hardware ###
Any build requires an environment variable known as `TEMPLATECONF` to be set
to a hardware target.  Choose the hardware target and then move to the next
step. Additional examples can be found in the
[OpenBMC Cheatsheet] (https://github.com/openbmc/docs/blob/master/cheatsheet.md)

Machine | TEMPLATECONF
--------|---------
Palmetto | ```export TEMPLATECONF=meta-openbmc-machines/meta-openpower/meta-ibm/meta-palmetto/conf```
Barreleye | ```export TEMPLATECONF=meta-openbmc-machines/meta-openpower/meta-rackspace/meta-barreleye/conf```
Zaius| ```export TEMPLATECONF=meta-openbmc-machines/meta-openpower/meta-ingrasys/meta-zaius/conf```
RaspberryPi| ```export TEMPLATECONF=meta-openbmc-machines/meta-evb/meta-evb-raspberrypi/conf```

### 3) Build ###

```
git clone git@github.com:openbmc/openbmc.git
cd openbmc
. openbmc-env
bitbake obmc-phosphor-image
```

Additional details can be found in the [docs](https://github.com/openbmc/docs)
repository.

## Build Validation and Testing ##
Commits submitted by members of the OpenBMC github community are compiled and
tested via our [Jenkins](https://openpower.xyz/) server.  Commits are run
through two levels of testing.  At the repository level the makefile `make
check` directive is run.  At the system level, the commit is built in to a
firmware image and run with a arm-softmmu QEMU model against a barage of
[CI tests](https://openpower.xyz/job/openbmc-test-qemu-ci/).

Commits submitted by non members do not automatically preceed through CI
testing. After visual inspection of the commit a CI run can be manually
performed by the reviewer.

Automated testing against the QEMU model along with supported systems are
performed.  The OpenBMC project uses the [Robot Framework]
(http://robotframework.org/) for all automation.  Our complete test
repository can be found [here](https://github.com/openbmc/openbmc-test-automation).

## Submitting Patches ##
Support of additional hardware and software packages is always welcome.
Please follow the [contributing guidelines](https://github.com/openbmc/docs/blob/master/contributing.md)
when making a submission.  It is expected that contributions contain test
cases.

## Bug Reporting ##
[Issues](https://github.com/openbmc/openbmc/issues) are managed on
github.  It is recommended you search through the issues before opening
a new one.

## Finding out more ##
Dive deeper in to OpenBMC by opening the [docs](https://github.com/openbmc/docs)
repository

## Contact ##
The peferred methods for contacting the openBMC community is
by mailing list and/or IRC.

- Mail: openbmc@lists.ozlabs.org  [https://lists.ozlabs.org/listinfo/openbmc]
(https://lists.ozlabs.org/listinfo/openbmc)
- IRC: #openbmc on freenode.net

