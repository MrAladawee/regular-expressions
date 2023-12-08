import java.net.URL

fun main(args: Array<String>) {

    /*
    Regular expressions
            Tasks
    */

    /*
    Task 1:
    Получить список аббревиатур из текста
    */

    var text = "Это курс информатики соответствует ФГОС и ПООП, это подтверждено ФГУ ФНЦ НИИСИ РАН"
    var regex = Regex("\\b[А-Я|Ё]+\\b")
    var result = regex.findAll(text)
    println(result.map { it.value }.toList())

    /*
    Task 2:
    Создать аббревиатуру из введенного текста
    */

    text = "Комитет государственной Безопасности"
    regex = Regex("\\b[а-я|А-Я|ё|Ё]")
    result = regex.findAll(text)
    println((result.map { it.value }.joinToString("").toUpperCase()))

    /*
    Task 3:
    Переименовать из camelCase в snake_case
    */

    text = "camelCaseVar"
    regex = Regex("([a-z])([A-Z])")
    val snakeCase = text.replace(regex, "$1_$2").toLowerCase()
    println(snakeCase)

    /*
    Task 4:
    Подсчет количества слов
    */

    text = """
    -Дельный, что и говорить,
    Был старик тот самый,
    Что придумал суп варить
    На колесах прямо.
    Суп - во-первых. Во-вторых,
    Кашу в норме прочной.
    Нет, старик он был старик
    Чуткий - это точно.
    """
    regex = Regex("\\b[А-Я|Ё|а-я|ё|-]+\\b")
    result = regex.findAll(text)
    println(result.map { it.value }.toList().size)

    /*
    Task 5:
    Поиск слов на a, e (eng)
    */

    text = "The following example creates an ArrayList with a capacity of 50 elements. Four elements are then added to the ArrayList and the ArrayList is trimmed accordingly."
    regex = Regex("\\b[a|A|e|E]\\w*\\b")
    result = regex.findAll(text)
    println(result.map { it.value }.toList())

    /*
    Task 6:
    Разделение текста на предложения
    */

    text = "Mr. Smith bought cheapsite.com for 1.5 million dollars, i.e. he paid a lot for it! Did he mind? Adam Jones Jr. thinks he didn't. In any case, this isn't true... Well, with a probability of .9 it isn't."
    val sentences = text.split(Regex("([.!?])\\s+"))
    //sentences.forEach { println(it) }

    /*
    Task 7:
    Поиск вхождения слова в большом тексте
     */

    val url = URL("https://www.gutenberg.org/files/2638/2638-0.txt")
    text = url.readText()
    regex = Regex("\\bthe\\b", RegexOption.IGNORE_CASE)
    println(text.count())
    //result = regex.findAll(text)
    //println(result.count())

}
