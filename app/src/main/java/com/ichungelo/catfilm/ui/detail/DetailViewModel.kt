package com.ichungelo.catfilm.ui.detail

import androidx.lifecycle.ViewModel
import com.ichungelo.catfilm.data.DataEntity
import com.ichungelo.catfilm.utils.DataDummy

class DetailViewModel : ViewModel() {
    private lateinit var dataId: String

    fun setDataId(dataId: String) {
        this.dataId = dataId
    }

    private fun getListData(): ArrayList<DataEntity> {
        return if (dataId[0] == 'm') {
            DataDummy.generateDataMovies() as ArrayList<DataEntity>
        } else {
            DataDummy.generateDataTvShows() as ArrayList<DataEntity>
        }
    }

    fun getDetailById(): DataEntity {
        lateinit var result: DataEntity
        val listData = getListData()
        for (data in listData) {
            if (data.dataId == dataId) {
                result = data
                break
            }
        }
        return result
    }
}