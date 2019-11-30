package com.viber.bot.util;

import com.google.common.base.Charsets;
import com.google.common.hash.Hashing;
import com.google.common.io.BaseEncoding;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SignatureValidator {

    private Logger logger = LoggerFactory.getLogger(SignatureValidator.class);
    private String secret;

    public SignatureValidator(String secret) {
        this.secret = secret;
    }

    public boolean validate(String signature, String data) {
        final String hash = encode(secret, data);
        logger.debug("Validating signature '{}' == '{}'", signature, hash);
        return hash.equals(signature);
    }

    private String encode(String key, String data) {
        final byte[] bytes = Hashing.hmacSha256(key.getBytes()).hashString(data, Charsets.UTF_8).asBytes();
        return BaseEncoding.base16().lowerCase().encode(bytes);
    }
}
