package com.ani.rest.crud

import lombok.AllArgsConstructor
import lombok.Getter
import lombok.NoArgsConstructor
import lombok.Setter
import lombok.ToString

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Setter
@Getter
data class App (
    var id: String,
    var cnt: Int
)