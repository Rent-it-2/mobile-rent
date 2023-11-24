package sptech.school.rent_it.utils

enum class Category {
    Ferramentas,
    Utensílios,
    Entretenimento,
    Vestuário,
    Eletrônicos
}

var categories: MutableList<Category> = mutableListOf(
    Category.Ferramentas,
    Category.Utensílios,
    Category.Entretenimento,
    Category.Vestuário,
    Category.Eletrônicos,
)