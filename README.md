# Реализованные тесты

## API: /api/calculator/calculate/

#### generalStructureTest
-	Проверяет структуру (наличие обязательных ключей) ответа.

#### generalContentTest
- Проверяет формулы, которые не меняют вид в зависимости от передаваемых параметров.

#### shortMarginFormulaTest / longMarginFormulaTest
- Проверяют формулу маржи, которая разнится в зависимости от передаваемых параметров.

#### cryptoTest
-	Проверяет отсутствие данных (swap) при передаче параметров с криптовалютой.
-	 Проверяет валютные пары.

#### negativeValuesTest
- Проверяет наличие сообщения об ошибке при передаче некорректных параметров (валюта, кредитное плечо, форекс, лот, биржа).

#### badFormTypeTest
- Проверяет наличие сообщения об ошибке при передаче некорректного значения типа счёта.

#### badLotTest
- Проверяет наличие сообщения об ошибке при передаче значения лота <=0.

## API: /api/calculator/forms/

#### accountDataTest
- Проверяет структуру ответа.


## Integration

#### AccountIntegrationTest
-	Выполняет запрос к API(/api/calculator/forms/).
-	Открывает страницу калькулятора.
-	Выбирает (поочерёдно) тип счёта и проверяет соответствие данных в дропдаунах (форекс, валюта счёта, кредитное плечо) UI данным из ответа API.

#### CalculatorIntegrationTest
- Выполняет запрос к API (/api/calculator/calculate/).
- Открывает страницу калькулятора и вводит данные соответствующие выполненному запросу.
-Сравнивает полученный в UI результат и формулы с ответом API.

## UI
#### CalculatorTest
-	Открывает страницу калькулятора.
- Вводит переданные данные.
- Проверяет наличие соответствующих формул и результата на странице. 

______________________________________________________________________________________

## Найдены ошибки:
### UI
- В UI возможно ввести значение меньше допустимого (0) в поле lot и произвести расчёт, который выдаст пустой список результата расчёта. При этом API на соответствующий запрос выдаёт корректное сообщение об ошибке, которое не выводится в UI.

### API: /api/calculator/calculate/
-	При передаче значения lot "100000000000000000" сайт падает с 500 ошибкой.
-	При передаче значения lot превышающего «максимально допустимое» (100000 + 1-11 нулей) не выводится сообщения об ошибке, а производится расчёт.

