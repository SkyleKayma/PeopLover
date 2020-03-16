package fr.skyle.peoplover.model.entity

import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import java.util.*

/**
 * Created by Openium on 19/02/2019.
 */
@Entity
data class PeopLove(
    @PrimaryKey
    var uid: Long = 0,
    var name: String? = null,
    var createdTime: Long? = null,
    var meetingTime: Long? = null
) {
    @Ignore
    var createdDate = Date(createdTime ?: 0L)

    @Ignore
    var meetingDate = Date(meetingTime ?: 0L)
}