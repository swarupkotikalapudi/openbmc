SUMMARY = "Witherspoon VRM Overrides"
DESCRIPTION = "Sets Witherspoon VRMs to custom voltages"
PR = "r1"

inherit obmc-phosphor-systemd
inherit obmc-phosphor-license

RDEPENDS_${PN} += "i2c-tools bash"

S = "${WORKDIR}"
SRC_URI += "file://vrm-control.sh \
	    file://ir35221-unbind-bind.sh"

do_install() {
        install -d ${D}${bindir}
        install -m 0755 ${WORKDIR}/vrm-control.sh ${D}${bindir}/vrm-control.sh
        install -m 0755 ${WORKDIR}/ir35221-unbind-bind.sh ${D}${bindir}/ir35221-unbind-bind.sh
}

TMPL_OFF = "ir35221-unbind-bind@.service"
TMPL_ON = "ir35221-unbind-bind@.service"
TMPL = "vrm-control@.service"
INSTFMT = "vrm-control@{0}.service"
TGTFMT = "obmc-chassis-poweron@{0}.target"
FMT = "../${TMPL}:${TGTFMT}.requires/${INSTFMT}"

SYSTEMD_SERVICE_${PN} += "${TMPL}"
SYSTEMD_LINK_${PN} += "${@compose_list(d, 'FMT', 'OBMC_CHASSIS_INSTANCES')}"
