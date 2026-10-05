package kh.com.exercise.model.general

data class MaterialComponentModel(
    val id: Int,
    val title: String,
    val description: String,
    val routeProvider: (MaterialComponentModel) -> Any,
    val icon: String,
)

fun MaterialComponentModel.route(): Any {
    return this.routeProvider.invoke(this)
}