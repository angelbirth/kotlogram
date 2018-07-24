package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException
import kotlin.Any
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.jvm.Throws

/**
 * inputPaymentCredentialsAndroidPay#ca05d50e
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLInputPaymentCredentialsAndroidPay() : TLAbsInputPaymentCredentials() {
    var paymentToken: TLDataJSON = TLDataJSON()

    var googleTransactionId: String = ""

    private val _constructor: String = "inputPaymentCredentialsAndroidPay#ca05d50e"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(paymentToken: TLDataJSON, googleTransactionId: String) : this() {
        this.paymentToken = paymentToken
        this.googleTransactionId = googleTransactionId
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeTLObject(paymentToken)
        writeString(googleTransactionId)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        paymentToken = readTLObject<TLDataJSON>(TLDataJSON::class, TLDataJSON.CONSTRUCTOR_ID)
        googleTransactionId = readString()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += paymentToken.computeSerializedSize()
        size += computeTLStringSerializedSize(googleTransactionId)
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLInputPaymentCredentialsAndroidPay) return false
        if (other === this) return true

        return paymentToken == other.paymentToken
                && googleTransactionId == other.googleTransactionId
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xca05d50e.toInt()
    }
}