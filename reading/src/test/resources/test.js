var PublicKey = "CF87D7B4C864F4842F1D337491A48FFF54B73A17300E8E42FA365420393AC0346AE55D8AFAD975DFA175FAF0106CBA81AF1DDE4ACEC284DAC6ED9A0D8FEB1CC070733C58213EFFED46529C54CEA06D774E3CC7E073346AEBD6C66FC973F299EB74738E400B22B1E7CDC54E71AED059D228DFEB5B29C530FF341502AE56DDCFE9";
var RSA = new RSAKey();
setPublic(PublicKey, "10001");
var PublicTs = "1600156342";

var b64map = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/";
var b64pad = "=";

function getCode(password) {
    var passCode = '';
    var Res = RSA.encrypt(password + '\n' + PublicTs + '\n');
    passCode = hex2b64(Res);

}

function RSAKey() {
    this.n = null;
    this.e = 0;
    this.d = null;
    this.p = null;
    this.q = null;
    this.dmp1 = null;
    this.dmq1 = null;
    this.coeff = null;
}

function hex2b64(b) {
    var d;
    var a;
    var e = "";
    for (d = 0; d + 3 <= b.length; d += 3) {
        a = parseInt(b.substring(d, d + 3), 16);
        e += b64map.charAt(a >> 6) + b64map.charAt(a & 63);
    }
    if (d + 1 == b.length) {
        a = parseInt(b.substring(d, d + 1), 16);
        e += b64map.charAt(a << 2);
    } else if (d + 2 == b.length) {
        a = parseInt(b.substring(d, d + 2), 16);
        e += b64map.charAt(a >> 2) + b64map.charAt((a & 3) << 4);
    }
    while ((e.length & 3) > 0)
        e += b64pad;
    return e;
}

function setPublic(b, a) {
    if (b != null && a != null && b.length > 0 && a.length > 0) {
        this.n = new BigInteger(b, 16);
        this.e = parseInt(a, 16);
    } else
        alert("Invalid RSA public key");
}

function BigInteger(d, e, f) {
    bnpFromString(d, e);
}

function bnpFromString(f, a) {
    var d;
    if (a == 16)
        d = 4;
    else if (a == 8)
        d = 3;
    else if (a == 256)
        d = 8;
    else if (a == 2)
        d = 1;
    else if (a == 32)
        d = 5;
    else if (a == 4)
        d = 2;
    else {
        return;
    }
    this.t = 0;
    this.s = 0;
    var c = f.length
        , e = false
        , g = 0;
    while (--c >= 0) {
        var h = (d == 8) ? f[c] & 0xff : intAt(f, c);
        if (h < 0) {
            if (f.charAt(c) == "-")
                e = true;
            continue;
        }
        e = false;
        if (g == 0)
            this[this.t++] = h;
        else if (g + d > this.DB) {
            this[this.t - 1] |= (h & ((1 << (this.DB - g)) - 1)) << g;
            this[this.t++] = (h >> (this.DB - g));
        } else
            this[this.t - 1] |= h << g;
        g += d;
        if (g >= this.DB)
            g -= this.DB;
    }
    if (d == 8 && (f[0] & 0x80) != 0) {
        this.s = -1;
        if (g > 0)
            this[this.t - 1] |= ((1 << (this.DB - g)) - 1) << g;
    }
    this.clamp();
    if (e)
        BigInteger.ZERO.subTo(this, this);
}