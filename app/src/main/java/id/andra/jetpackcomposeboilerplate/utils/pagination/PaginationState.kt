package id.andra.jetpackcomposeboilerplate.utils.pagination

data class PaginationState<T>(
    val items: List<T> = emptyList(),
    val isLoading: Boolean = false,
    val isEndReached: Boolean = false
)
