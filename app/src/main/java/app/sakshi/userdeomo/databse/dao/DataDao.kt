package app.sakshi.userdeomo.databse.dao

import androidx.room.*
import app.sakshi.userdeomo.databse.model.DataEntity

@Dao
interface DataDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addUser(user: DataEntity)

    @Update
    fun updateUser(user: DataEntity)

    @Delete
    fun deleteUser(user: DataEntity)


    @Query(value = "SELECT * FROM data")
    fun getAllData(): List<DataEntity>
}