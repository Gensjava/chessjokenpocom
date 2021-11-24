package com.example.gena.chessjokenpocom.app.enums

enum class HttpStatusHelper(val value: Int, val reasonPhrase: String) {
    FAILED_TO_CONNECT(408, "No access to the server, please check the network connection."),
    REQUEST_TIMEOUT(408, "Request Timeout"),
    ERROR_RECORD_INVALID_CREATED(453, "This record has already been created!"),
    INTERNAL_SERVER_ERROR(500, "Internal Server Error"),
    ERROR_USER_INVALID_CREATED(452, "This user has already been created"),
    ERROR_DID_NOT_FIND_DATA(453, "Data not found!")
}
