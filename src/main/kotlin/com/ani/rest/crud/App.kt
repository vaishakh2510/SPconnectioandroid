package com.ani.rest.crud
import lombok.AllArgsConstructor
import lombok.EqualsAndHashCode
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
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as App

        return id == other.id
    }

    override fun hashCode(): Int {
        return id.hashCode()
    }
}