package travelator

/**
 * 데이터 클래스를 사용했을 때 data class
 * - equals & hashcode 및 다양한 함수를 자동으로 만들어준다.
 * - java 최신버전에 record와 같다.
 */

data class EmailAddress(
    val localPart: String,
    val domain: String
) {

    override fun toString(): String {
        return "$localPart@$domain"
    }

    companion object {
        @JvmStatic
        fun parse(value: String): EmailAddress {
            val atIndex = value.lastIndexOf('@')
            require(!(atIndex < 1 || atIndex == value.length - 1)) { "EmailAddress must be two parts separated by @" }
            return EmailAddress(
                value.substring(0, atIndex),
                value.substring(atIndex + 1)
            )
        }
    }
}