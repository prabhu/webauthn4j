/*
 * Copyright 2018 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.webauthn4j.data.extension.client;

import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

@SuppressWarnings("deprecation")
class AuthenticationExtensionsClientOutputsTest {

    @Test
    void instance_can_store_concrete_extension_test() {
        GenericTransactionAuthorizationExtensionClientOutput.TxAuthnGenericArg value = new GenericTransactionAuthorizationExtensionClientOutput.TxAuthnGenericArg("dummy", new byte[32]);
        GenericTransactionAuthorizationExtensionClientOutput genericTransactionAuthorizationExtensionClientOutput = new GenericTransactionAuthorizationExtensionClientOutput(value);
        assertThatCode(() -> {
            AuthenticationExtensionsClientOutputs<AuthenticationExtensionClientOutput> clientExtensions =
                    new AuthenticationExtensionsClientOutputs<>(Collections.singletonMap(GenericTransactionAuthorizationExtensionClientOutput.ID, genericTransactionAuthorizationExtensionClientOutput));
            assertThat(clientExtensions.size()).isEqualTo(1);
        }).doesNotThrowAnyException();
    }

}