package id.andra.jetpackcomposeboilerplate.utils.pagination

import id.andra.jetpackcomposeboilerplate.utils.network.Resource

class Pagination<T>(
    private val onLoadUpdated: (isLoading: Boolean, page: Int) -> Unit,
    private val onRequest: suspend (nextPage: Int) -> Resource<List<T>>,
    private val onError: suspend (message: String) -> Unit,
    private val onSuccess: (items: List<T>) -> Unit
) {

    private var page = 1

    suspend fun loadNextItems() {
        onLoadUpdated(true, page)
        when (val result = onRequest(page)) {
            is Resource.Success -> {
                val items = result.data ?: emptyList()
                onSuccess(items)
                page++
                onLoadUpdated(false, page)
            }

            is Resource.Error -> {
                onError(result.error?.message.orEmpty())
                onLoadUpdated(false, page)
            }
        }
    }

    fun getPage() = page

    fun resetPage() {
        page = 1
    }

}