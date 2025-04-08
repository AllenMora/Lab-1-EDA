import java.util.Scanner;

public class Vigenere {
    static String chars = "abcdefghijklmnñopqrstuvwxyzABCDEFGHIJKLMNÑOPQRSTUVWXYZ0123456789";

    static String[] testPasswords = {
        "coUzdr0fkd",
        "5KkdI90DMsjT8NzsTHKdTaYDD76r6MyfTeO9u7imOJ7HfT18Ko",
        "V7vN6vm5lmNaDWcXIPopfnUEo3VxJc3Q2waXx7Ju3fqly1OIdZFWvv8ToPpJ1CAcxf6bysZgQvñRNSmñDOqGÑLsNJxÑp6SqxZxLv",
        "sJrzmN5711mkRQ8TczJvsdSsgROAK62OUzO0PRvKKzniqXOej2mkap0XhwJV0a0D6mE0BKVaiSbXAeHJ0epAñBHñPYOpujr08jDCmIAxAJ9ekclpJXNmUxWOGI7p6GneQgnlfjQkeCNFrMInAZW7sNMos1jlhwzamhqvgK27V2Fim47n93XE9kXtiLJFxtquCodTbY3vKJDMtSqKMy90i7IFvHTDvCKjW99Y1ie2tTfyñEM5W63gJzAYI189bSWoxyF4G5UñTtjEgrjkLÑQOtwOcPHdto7m8CEIzÑbdCXEbUB6ByOQ0wmIrUEXXfqiJlhJÑfXni1OMoNhNV2mDgQ4lvpFxJbkzmV60sVñYfñYT1HMw5W6Zy8wTwhqQrEFanhsGsz7nIMSs9kRLp1NfdLQrZqpñGÑ0A357ñYhiofPgRkRAKqfGSb5gñV9f7OFHPvXfilmgHJTj2nwrzfUU0xR8CZgÑ2d3sucIZtxFuhRXQdwpDCAgjOcy",
        "jkD92poSqxskxvoLUzRZ6jvwUdBqjHHpA1V1IAET31Y56D68G1bfwÑq9G92bvuA9BB8OS6vueAWjsDn97ÑRGXgbxzjfZsAbwRzvlWy29zbJJiOg7xh57c61uY9jfd4yItiE52xMJjvEvmgañIqgTNAzÑ1nzw3wXNDrh0bZymihHKqam9BpCpsGA1pWQgVe00BfMLb7zyvÑapjZdGfBEurCXcD6bUhsxmpihNvHl5QrUCWOwPMtr3AEg3Uneixe1pICaa41vBQeoczmbC9W5tjñNzuwcQLjVw2RWiBdV8Y7WwHi9jlZOV2vkrSY0KNUbñpwIm0WQBñjf3IZ7HÑQf8Le7uWXl0GqFGJqsTuxZaqAaFbaH3hPh98xPrydI8TEGEyñ2gNpJmdlQgAfgOuV09NiGEjUJkBu2ZWfdÑÑXdBfdmNswhQiEOKYKL9vkS1NcuLZBVVBdhuRHdvkaO2Av8ujpgMju9pOu9mu5NJdX8tO0pg8Dl2ñ9f4ñzBcSKvm1HHP8Ñe8dSsbmfnEUQUXOf6TWeHtr29bpipquCkÑIh6FaTFqMfIdknV9MOSXjZ5xbhPuiXcLñ5oOXEB19GCUO11Sb7PdJKFoxHONXUvNUFvMdqIÑvÑEKxWyFÑ4rMLm7p13mVrfK13LoTdLSlñrt2ITn8KFnZO3nB6Zcx1LMVKLC1MJF6sftVPm1VIxÑSbWX8P3LygefbhLEÑnQTM0w9Ssveñ6QuORñkFXK8bGBPyMwb8Ñy7LDVgUepjiJsf9RPgdKVQPzGT34i8sQaNVOpfHIMÑNeugbNZ4LxdJXJ67FvECf0vnblX8rDuECjÑ4GXA0K2cPqyorNeMfjacJzsxu0g9IQcFy8WRFj3WgN7DsmR2xagñQ4j4ZXWTZVñnZTnO4r8Vpm0oMaV0U9TNmU6XcTgJ8sYxC23iLñZbZoJzQm9xNiHXzgpmYl8T7GE6qMnlqLujko5sqwLkb917hYXXx1AioDbqRyb5qtZ4XaAl18Iux0",
        "41YdGÑO6UZ7ov4dLLtdFAj63QceuGsh2YRpo5lfoGiHWDh715n52DpkTJC26widoqpClrÑsqC8QIbvSQmi8r3a0tDAIHE29qIQhLLvd0ChUeFIIrTllJKsx3Ss7BTlDLVe2qkZyaFr1k94NNWUeqcAp0jB1YC6PvyddN7dx8GSQursHÑsoXJTBN6XsUZa1DEItiUqrfcvpCuTWlÑmr3bFJjby42pS4ouUww0upJ7whb2gÑPHaGoZDXRM436dYK8hYgXvw68o5JBUcY7TRIñNFudk3Lzo15orWÑ4B4j1Kli3BñVJXKA53azsbKV9zZOñZlcHud8L9KYSgXVbbEi6xh9gKByaDqnÑOviBQoZD4WjpÑrcTP10lzñmeNKK0hN5vwuMhRnPCjCVñCqk4lMTTqm2ñDñMIwLQaTIqX3nm8fBuETñLY4S0ofQlTñxzhD5M9uErN5TX6bF2brYEQMyI9RBIÑjfA21uÑS3w12k3u5ZGPMveYzaIjKaMOTqHgSvXrvPCYvgfsBZ3dxjFArLmGnV5Xb1TFX1uKGwÑCa7myñdVhZnñdVuM9jzq9P6dZo8bbJyJ2QXSÑwyWKsDP9eb2ñGTXpGRw3AGD8JmRobjOiyWfQU0rñCh1ñcGXZPhwZx3OR7IabFPOAFz99fKASR4vsbHF1f9lY2r5bpkfRÑZGjDPc33Ñ59riGrOCNyV8PZgjzrQÑlpdwR1mnrkusRmoEÑjo1n3ucXUWD3uOTOK6DIMoB14YgxmdÑwÑRG3tl8wMZ2IMqO4xWbhñbJmw0v3nWLCZsaeDP6WdXOXhVGaaYñGÑKDv7V5OohaewJjvdCCrwnNLnLVBfHokcFFiÑMBUñ1A3W7hÑzZJMIBñmibAbk6yKQAyD5ÑSYwwXzNQmk0WÑXfX8lSB3MlwzKgvuYZUQSXPZDwysSOG2gsMOQ83rx072Q0cñ50r564UCFuhAY7qGNIf0ik8v90OnFjAqmds7Tf3gU3yR0pvZUSzNoñclBh8tVMwQOrUOPhlkAwuv12tRAOkZmZmb7GfSiññtwta1hñuoÑfZXVa57ZzizQEd3vtCqWwZv9Ñ413Us22k2ko4xoZQ5v4uE42u6UTNVvÑpwT5BD8MxQQeÑVHnU4j7npxmmIqGgDy4N217ñXL1HDGrIXX8ñ0RONSHnGÑWe3gnqzz1412yrf5TtacclpfW6B6R7OjcbSU3jsWVÑuq9WsiPjCkmSDG7cxK4uOMzU6ws271yikQ0iuFÑtPlSPuNEbpQ3Tnv67aMCXlGmS4oTROvmzwGOYsuB1vñRBokZrytxVHxbBHww1D0p9S94zpDH6M6NvAtydpñcEEOx25080M50ByEswrqBv0sIfFQHRni7lunOhK9jHiejNTlgEDfEÑg0jychnZ6g06B2YK1bSMZ6kBB4JBUJd5DEgÑUjNvIRuLpbRNDy4tYqJ6jbKpuv26wKhMvpdFwxTHtpUC4GpFukJ9ItETBBF5FWjPvñdLK5AxPiqNJ0ñFYPIqrxMwCHXqñEiya6DfhhROL6F1rQsqiGi3jUx1tihnji5ktaiAw2ekIu58PXvppAIrEjs13biCeYvarqwFAZDNbqCqpJoKPRpiMH433Ff0YZyxi2ko43rMpjK9uMWTsqiZhOrhxEXRjGvf4mWKGp3QzZrJRDY2TZÑBt6hggQUÑvlmcbRsEBZsRG4pZvñ52Ei0N6wT3926ouW2lgVDFsS15ZazjjIK8a7KOEjVMc9CÑW5f6jmpeYAq7QÑITn6cjFsdñieQm5D45jl3VA1gFyqNg9Ua2PZr8rBB8dS8gHU2EQBo63Ah7mtPxGnnUñ2FtB7hqiKv5QbvrpVZDdZfHAIOcTgñm4ÑaxxReDSMRwuQ0q2B5O7HIvfTÑF2qsztAkA9z8k5CtRl7mQBfgcGeaye4ErzÑObtLH6L1bqxeYcpZuñBw6BZñS2LKCvgygeGvPuTJ7i9YgounWKgD95MN9Wz4py51daOrE6ERÑozJZJKvkZ5FUjmÑ7WInyjH66voRe90KzkUGbNoNycMjuf1cJBiHxdStQBz2CQzWÑPttvOl5N8MUMGZW8FeFno6xVv3DjcFmVelpRM9Ui2JMwNhPY20ñuchiUIYhoxMeEEORC6OmHpñÑñzZ3ynnnKiGUd0x5mWXD8Nh4FNpsTRGIbielBo24aCadwG8buPr7xxZspOctWRyFimVeOgCSSñ4VYfTtvH9OGMrñpLyEnVclP1QN7H3JANTPG0OñZywMo7UoGeehBdVP8rYHeLDSCBnjUBlI01ogNl1nuYFEWivoOK1E8ZOpG4on4vÑU2hqojiRfZgnc4TGDgoC5kpCTsZEpNbehGxq2zñqy9NyIAJuiAwXPxaZcJ1sMMEnVkHTiSYSGe9yYZmreSjR2f6gVzBZr1QfhCkjBgNfBmve6ZT4GeñklMnhIZ8T7jn5a6uUT2ÑVsPALbMa5c08TwAÑ0N9Kn55gGÑlHVNp9hjuBEqñYynUchCpmHUCfJJlrcWQOnsÑCurS1AtH0ñcaDC9TtMpWRvP8ELfstoPIHzkTGgEzbrWLwBzSrbsjÑKd2HAAPEviDPehNYRCfFm0A6UvMABYoXtMNSspxjP5LpiOgiÑ3Tp7KXLBMÑkoBv8E1KRqgGYKgWOB9HMOñ5rumiVjÑJPeR9QV72WjRsid0d2tLpzza6eTVGHUax7NifdtkyGqXFUagD2GyjziGkeODMXc1Mh3hjAxrSrypicfJABt0TAHVENYWNLdVj9JlQPnGcG734GWNBgFgM9aoKUOLLu2qwhm2ñmLgrzdYsddBLtxeG8pnYJTa7zwe6d496XIPEBZnTVdvKYESukdufqAiQtzjygy1QI7ar6zH5HmUñOÑ8bdQMryNi7MHxzupWOQW9YLt3FdJjxLA6W2u2ñbRqAHzwXoPPTE0Ocx2nonCdDjn0xGaPPZgñaBl4azK511TQKK1aMo009ULh9939RyslGVtS0esbu47JepBfAzomrIrvOÑ2Oh8ETMN1ñafGOzuM6oLsdEZURñQrnNnEOUwDbvPXc5v5DVIvoD5Nb4Y7OtGL8iJHkSOSYDFGKYvWlRqKzEymoMsKLBkbBFuw2TDr0IUj0zoMr7zj8oQYhR6g3qxhGfQyUHqou7HRe6wX9MJhbZABEF3uVXatXQPñieK9f4mJX70ItIBÑ8xfBx5koSi36f9Mi0V8J7mNkr0WPOBZgnaRuQ6QqcDog7nbWmCaaHceBv1BiVUGDUFLytsc2rGV2JF681LxAJFqBPrcwmÑoeO1E0ÑE7gñSxiMAo6RXqVrtñsclFdFgDDctmeopb5vVPc6hgj4ÑrzHÑYlHj9KkRÑJ9NNLyGPzñudLtYq9AZKSrlHPEDGÑZhHOcYQpdiDDS3dJj8gtJv58TbobmVpW8C8U725rEWaMjgxB5PNuPo0zñ7rMemXuL18V5TCKgQyEA3QAYSFSiFqDFYpVJTh8SLUQSRUiTñ3S5odiRO0qhCtKVcekKomBFdÑEÑOuzEnmYJXcUaL2aeZR3mq8YdÑ565zDj5uypRhfñ6fpaGIIR5ñFvUGMfAXCemKGHRLM32RjoYqu5k7bTADoumHzRgÑ7kbzFAXVWfQULhcQMHTWVVNOnduÑIkbnrQM6PZ5wUmt4eÑpXeOegI09gJImWx0OwdH3AuBCq0TTIoxEIwg2Ñm5pWbkE0G9k6x0TxS0l9IsNRzU0AZI2JygTCL6MLDNKHdSs9ID3Q8feETlpE4IiE0KvhLk2swmAntywNN6IfjpVuvuLdmJC7MFQ2eVpNTHNbniOgjICR4mF7HÑxXD28MGnLuIsK6W73ev7mñqWñl45KArFvIfKj0RXIBw1KBuuZBsi1pm4g90mRLbMo6hVTn6NGsmvqDKCnbLcE4fMM4KKfEUIIRV8X6l78PDXsWu2C9t70W7q4MTg9xxh8eiC57mKo5HgRBp1mJjMkxfK7AHj6Y9DVRfmñzM0evXXhA69IQmuHYNLRk2mQdPIeFI1ncYh3W51J5ahT1fNRE8ju98RwUseDQtEjmvk1ETTMivSBjgyPyWV9tUP2KñptCNFvJGp9i1wHYH0ñAÑ2uLId335Y0U7wrnltqzBzGbPÑQQLG6KGk3kOWgÑ72WGd4pewf8VoLzyWyOhaBnqXcVgesD0jvpkNuGYFD08oñprzC3xahksym6eU3Q2XrBKCZñia2o8zs2tUhuprmñiiDb38AÑC7d3leFBFXvpD8l6kMBffsRMQD8rCqFsmYQXSfHQ4IJSJkyk47RtK37slahw5SHrf5hXon9zmHnWs437cGD5XÑWoYIRjIxJIwScj9ZPym1N7OU8hO8WRixS8ysmGUTYHx6zeExaJWbml7ejNUi8OopNui5byQe2At9YNWDnhcMopñdUZ9skejK7FkM0cvf8Ñ79sGDswADCwn4RMmM0iwFjOLANZkGGKEojtGIfWatb2Juqw08Syoj6X7ñlz1aePLKD17CHM4qrqZLyUAaHjyuiBd9sBehGG8jGhs8085rñiWssSWIt0lkTjqQSD9PqgfuG0a7aÑM7ñ6FbtQñ6IWSRñcevlvcPUp4ÑdGHpAKKiC1ccjyqCsS4tzVVkjXlxHu8GWgApEñ8VI5r8xcpHZ5wFTC7m6iOj9D38R3q25MhSHJrw10z9qW8dmzAUaE6Qd3GuCOmME43NGVDXe6TSFVcxxWh9cOOGrK6YLMYIzKNrSñhRruG9uPñMkyRQñuoeGUTk4Nejv5NlmLYTQSqn7YqZemO8L5UBZPow3DkpFDq0kOdvdntgpwlR5Pk9NFI0g1AÑWaSaF8ñb814sJ9jDAuNfklZRDh7wcxZVINpaRakrMHe4OAqRjHLkj9OgO6acA5GVXM7u370lZLceQyiPqFZbVye3anQNQ1A3QsywDkohKh6oLSPGfeUKydfkfRd3nZfPiyL0JfdHDfXAyxgAY4lkcAPD7VlIdh3kñU6e1fXa3CXRñM6hek1OaaTxYwPlb9FoÑlTtyZYRbyCPhI55kKXYqoAfQYIRwARkLQfmBiAm47m30Ypbum5hReQ1QVE5"
    };

    static String testMessage = "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis, sem. Nulla consequat massa quis enim. Donec pede justo, fringilla vel, aliquet nec, vulputate eget, arcu. In enim justo, rhoncus ut, imperdiet a, venenatis vitae, justo. Nullam dictum felis eu pede mollis pretium. Integer tincidunt. Cras dapibus. Vivamus elementum semper nisi. Aenean vulputate eleifend tellus. Aenean leo ligula, porttitor eu, consequat vitae, eleifend ac, enim. Aliquam lorem ante, dapibus in, viverra quis, feugiat a, tellus. Phasellus viverra nulla ut metus varius laoreet. Quisque rutrum. Aenean imperdiet. Etiam ultricies nisi vel augue. Curabitur ullamcorper ultricies nisi. Nam eget dui. Etiam rhoncus. Maecenas tempus, tellus eget condimentum rhoncus, sem quam semper libero, sit amet adipiscing sem neque sed ipsum. Nam quam nunc, blandit vel, luctus pulvinar, hendrerit id, lorem. Maecenas nec odio et ante tincidunt tempus. Donec vitae sapien ut libero venenatis faucibus. Nullam quis ante. Etiam sit amet orci eget eros faucibus tincidunt. Duis leo. Sed fringilla mauris sit amet nibh. Donec sodales sagittis magna. Sed consequat, leo eget bibendum sodales, augue velit cursus nunc, quis gravida magna mi a libero. Fusce vulputate eleifend sapien. Vestibulum purus quam, scelerisque ut, mollis sed, nonummy id, metus. Nullam accumsan lorem in dui. Cras ultricies mi eu turpis hendrerit fringilla. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; In ac dui quis mi consectetuer lacinia. Nam pretium turpis et arcu. Duis arcu tortor, suscipit eget, imperdiet nec, imperdiet iaculis, ipsum. Sed aliquam ultrices mauris. Integer ante arcu, accumsan a, consectetuer eget, posuere ut, mauris. Praesent adipiscing. Phasellus ullamcorper ipsum rutrum nunc. Nunc nonummy metus. Vestibulum volutpat pretium libero. Cras id dui. Aenean ut eros et nisl sagittis vestibulum. Nullam nulla eros, ultricies sit amet, nonummy id, imperdiet feugiat, pede. Sed lectus. Donec mollis hendrerit risus. Phasellus nec sem in justo pellentesque facilisis. Etiam imperdiet imperdiet orci. Nunc nec neque. Phasellus leo dolor, tempus non, auctor et, hendrerit quis, nisi. Curabitur ligula sapien, tincidunt non, euismod vitae, posuere imperdiet, leo. Maecenas malesuada. Praesent congue erat at massa. Sed cursus turpis vitae tortor. Donec posuere vulputate arcu. Phasellus accumsan cursus velit. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Sed aliquam, nisi quis porttitor congue, elit erat euismod orci, ac placerat dolor lectus quis orci. Phasellus consectetuer vestibulum elit. Aenean tellus metus, bibendum sed, posuere ac, mattis non, nunc. Vestibulum fringilla pede sit amet augue. In turpis. Pellentesque posuere. Praesent turpis. Aenean posuere, tortor sed cursus feugiat, nunc augue blandit nunc, eu sollicitudin urna dolor sagittis lacus. Donec elit libero, sodales nec, volutpat a, suscipit non, turpis. Nullam sagittis. Suspendisse pulvinar, augue ac venenatis condimentum, sem libero volutpat nibh, nec pellentesque velit pede quis nunc. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Fusce id purus. Ut varius tincidunt libero. Phasellus dolor. Maecenas vestibulum mollis diam. Pellentesque ut neque. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. In dui magna, posuere eget, vestibulum et, tempor auctor, justo. In ac felis quis tortor malesuada pretium. Pellentesque auctor neque nec urna. Proin sapien ipsum, porta a, auctor quis, euismod ut, mi. Aenean viverra rhoncus pede. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Ut non enim eleifend felis pretium feugiat. Vivamus quis mi. Phasellus a est. Phasellus magna. In hac habitasse platea dictumst. Curabitur at lacus ac velit ornare lobortis. Curabitur a felis in nunc fringilla tristique. Morbi mattis ullamcorper velit. Phasellus gravida semper nisi. Nullam vel sem. Pellentesque libero tortor, tincidunt et, tincidunt eget, semper nec, quam. Sed hendrerit. Morbi ac felis. Nunc egestas, augue at pellentesque laoreet, felis eros vehicula leo, at malesuada velit leo quis pede. Donec interdum, metus et hendrerit aliquet, dolor diam sagittis ligula, eget egestas libero turpis vel mi. Nunc nulla. Fusce risus nisl, viverra et, tempor et, pretium in, sapien. Donec venenatis vulputate lorem. Morbi nec metus. Phasellus blandit leo ut odio. Maecenas ullamcorper, dui et placerat feugiat, eros pede varius nisi, condimentum viverra felis nunc et lorem. Sed magna purus, fermentum eu, tincidunt eu, varius ut, felis. In auctor lobortis lacus. Quisque libero metus, condimentum nec, tempor a, commodo mollis, magna. Vestibulum ullamcorper mauris at ligula. Fusce fermentum. Nullam cursus lacinia erat. Praesent blandit laoreet nibh. Fusce convallis metus id felis luctus adipiscing. Pellentesque egestas, neque sit amet convallis pulvinar, justo nulla eleifend augue, ac auctor orci leo non est. Quisque id mi. Ut tincidunt tincidunt erat. Etiam feugiat lorem non metus. Vestibulum dapibus nunc ac augue. Curabitur vestibulum aliquam leo. Praesent egestas neque eu enim. In hac habitasse platea dictumst. Fusce a quam. Etiam ut purus mattis mauris sodales aliquam. Curabitur nisi. Quisque malesuada placerat nisl. Nam ipsum risus, rutrum vitae, vestibulum eu, molestie vel, lacus. Sed augue ipsum, egestas nec, vestibulum et, malesuada adipiscing, dui. Vestibulum facilisis, purus nec pulvinar iaculis, ligula mi congue nunc, vitae euismod ligula urna in dolor. Mauris sollicitudin fermentum libero. Praesent nonummy mi in odio. Nunc interdum lacus sit amet orci. Vestibulum rutrum, mi nec elementum vehicula, eros quam gravida nisl, id fringilla neque ante vel mi. Morbi mollis tellus ac sapien. Phasellus volutpat, metus eget egestas mollis, lacus lacus blandit dui, id egestas quam mauris ut lacus. Fusce vel dui. Sed in libero ut nibh placerat accumsan. Proin faucibus arcu quis ante. In consectetuer turpis ut velit. Nulla sit amet est. Praesent metus tellus, elementum eu, semper a, adipiscing nec, purus. Cras risus ipsum, faucibus ut, ullamcorper id, varius ac, leo. Suspendisse feugiat. Suspendisse enim turpis, dictum sed, iaculis a, condimentum nec, nisi. Praesent nec nisl a purus blandit viverra. Praesent ac massa at ligula laoreet iaculis. Nulla neque dolor, sagittis eget, iaculis quis, molestie non, velit. Mauris turpis nunc, blandit et, volutpat molestie, porta ut, ligula. Fusce pharetra convallis urna. Quisque ut nisi. Donec mi odio, faucibus at, scelerisque quis, convallis in, nisi. Suspendisse non nisl sit amet velit hendrerit rutrum. Ut leo. Ut a nisl id ante tempus hendrerit. Proin pretium, leo ac pellentesque mollis, felis nunc ultrices eros, sed gravida augue augue mollis justo. Suspendisse eu ligula. Nulla facilisi. Donec id justo. Praesent porttitor, nulla vitae posuere iaculis, arcu nisl dignissim dolor, a pretium mi sem ut ipsum. Curabitur suscipit suscipit tellus. Praesent vestibulum dapibus nibh. Etiam iaculis nunc ac metus. Ut id nisl quis enim dignissim sagittis. Etiam sollicitudin, ipsum eu pulvinar rutrum, tellus ipsum laoreet sapien, quis venenatis ante odio sit amet eros. Proin magna. Duis vel nibh at velit scelerisque suscipit. Curabitur turpis. Vestibulum suscipit nulla quis orci. Fusce ac felis sit amet ligula pharetra condimentum. Maecenas egestas arcu quis ligula mattis placerat. Duis lobortis massa imperdiet quam. Suspendisse potenti. Pellentesque commodo eros a enim. Vestibulum turpis sem, aliquet eget, lobortis pellentesque, rutrum eu, nisl. Sed libero. Aliquam erat volutpat. Etiam vitae tortor. Morbi vestibulum volutpat enim. Aliquam eu nunc. Nunc sed turpis. Sed mollis, eros et ultrices tempus, mauris ipsum aliquam libero, non adipiscing dolor urna a orci. Nulla porta dolor. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos hymenaeos. Pellentesque dapibus hendrerit tortor. Praesent egestas tristique nibh. Sed a libero. Cras varius. Donec vitae orci sed dolor rutrum auctor. Fusce egestas elit eget lorem. Suspendisse nisl elit, rhoncus eget, elementum ac, condimentum eget, diam. Nam at tortor in tellus interdum sagittis. Aliquam lobortis. Donec orci lectus, aliquam ut, faucibus non, euismod id, nulla. Curabitur blandit mollis lacus. Nam adipiscing. Vestibulum eu odio. Vivamus laoreet. Nullam tincidunt adipiscing enim. Phasellus tempus. Proin viverra, ligula sit amet ultrices semper, ligula arcu tristique sapien, a accumsan nisi mauris ac eros. Fusce neque. Suspendisse faucibus, nunc et pellentesque egestas, lacus ante convallis tellus, vitae iaculis lacus elit id tortor. Vivamus aliquet elit ac nisl. Fusce fermentum odio nec arcu. Vivamus euismod mauris. In ut quam vitae odio lacinia tincidunt. Praesent ut ligula non mi varius sagittis. Cras sagittis. Praesent ac sem eget est egestas volutpat. Vivamus consectetuer hendrerit lacus. Cras non dolor. Vivamus in erat ut urna cursus vestibulum. Fusce commodo aliquam arcu. Nam commodo suscipit quam. Quisque id odio. Praesent venenatis metus at tortor pulvinar varius. Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis, sem. Nulla consequat massa quis enim. Donec pede justo, fringilla vel, aliquet nec, vulputate eget, arcu. In enim justo, rhoncus ut, imperdiet a, venenatis vitae, justo. Nullam dictum felis eu pede mollis pretium. Integer tincidunt. Cras dapibus. Vivamus elementum semper nisi. Aenean vulputate eleifend tellus. Aenean leo ligula, porttitor eu, consequat vita";

    public static class BigVignere {
        int[] key;
        char[][] alphabet;

        private void generateAlphabet() {
            alphabet = new char[chars.length()][chars.length()];
            for (int i = 0; i < chars.length(); i++) {
                for (int j = 0; j < chars.length(); j++) {
                    int index = i + j;
                    if (index >= chars.length()) {
                        index -= chars.length();
                    }
                    alphabet[i][j] = chars.charAt(index);
                }
            }
        }

        private void setKey(String key) {
            this.key = new int[key.length()];
            for (int i = 0; i < key.length(); i++) {
                this.key[i] = key.charAt(i);
            }
        }

        public BigVignere(String key) {
            setKey(key);
            generateAlphabet();
        }

        public BigVignere() {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Ingrese la clave: ");
            String key = scanner.nextLine();
            setKey(key);
            scanner.close();
            generateAlphabet();
        }

        private int getCharIndex(int character) {
            for (int i = 0; i < alphabet.length; i++) {
                if (alphabet[i][0] == character) {
                    return i;
                }
            }
            return -1;
        }

        public String encrypt(String message) {
            StringBuilder encryptedMessage = new StringBuilder();
            int keyIndex = 0;
            for (int i = 0; i < message.length(); i++) {
                char messageChar = message.charAt(i);
                if (messageChar == ' ') {
                    encryptedMessage.append(' ');
                    continue;
                }
                int messagePos = getCharIndex(messageChar);
                if (messagePos == -1) {
                    encryptedMessage.append('?');
                    continue;
                }
                int keyChar = key[keyIndex % key.length];
                int keyCol = getCharIndex(keyChar);
                encryptedMessage.append(alphabet[messagePos][keyCol]);
                keyIndex++;
            }
            return encryptedMessage.toString();
        }

        public String decrypt(String message) {
            StringBuilder decryptedMessage = new StringBuilder();

            int keyIndex = 0;
            for (int i = 0; i < message.length(); i++) {
                char messageChar = message.charAt(i);
                if (messageChar == ' ') {
                    decryptedMessage.append(' ');
                    continue;
                } else if (messageChar == '?') {
                    decryptedMessage.append('?');
                    continue;
                }
                int keyChar = key[keyIndex % key.length];
                int keyRow = getCharIndex(keyChar);
                int originalPos = -1;
                for (int j = 0; j < alphabet.length; j++) {
                    if (alphabet[keyRow][j] == messageChar) {
                        originalPos = j;
                        break;
                    }
                }
                decryptedMessage.append(chars.charAt(originalPos));
                keyIndex++;
            }
            return decryptedMessage.toString();
        }

        public void reEncrypt() {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Ingrese el mensaje encriptado:");
            String encryptedMessage = scanner.nextLine();
            String decryptedMessage = decrypt(encryptedMessage);
            System.out.print("Ingrese la nueva clave de encriptacion: ");
            String newKey = scanner.nextLine();
            setKey(newKey);
            String newEncryptedMessage = encrypt(decryptedMessage);
            System.out.println("El mensaje encriptado con la nueva clave es: " + newEncryptedMessage);
            scanner.close();
        }

        public char search(int position) {
            for (int i = 0; i < alphabet.length; i++) {
                for (int j = 0; j < alphabet.length; j++) {
                    if (position == i * alphabet.length + j) {
                        return alphabet[i][j];
                    }
                }
            }
            return '?';
        }

        public char optimalSearch(int position) {
            int row = position / alphabet.length;
            int col = position % alphabet.length;
            return alphabet[row][col];
        }

        public void startTest() {
            System.out.println("Iniciando test de encriptacion.\n");
            for (int i = 0; i < testPasswords.length; i++) {
                long startTime = System.nanoTime();
                String pass = testPasswords[i];
                System.out.println("Iniciando test para clave de " + pass.length() + " caracteres.\n");
                setKey(pass);
                String encryptedMessage = encrypt(testMessage);
                decrypt(encryptedMessage);

                long endTime = System.nanoTime();
                long duration = endTime - startTime;

                System.out.println("Duracion del test de encriptacion: " + duration + " nanosegundos.");
                System.out.println("Duracion del test de encriptacion: " + duration / 1000000 + " milisegundos.\n");
            }
            System.out.println("--------------------------------------------------");
        }
    }
    public static void main(String[] args) {
        BigVignere vignere = new BigVignere("holabuenas");

        // test de encriptacion
        vignere.startTest();

        // test de busqueda
        System.out.println("Iniciando test de busqueda.\n");
        long startTime = System.nanoTime();
        for (int i = 0; i < chars.length() * chars.length(); i++) {
            vignere.search(i);
        }
        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        System.out.println("Duracion del test de busqueda: " + duration + " nanosegundos.");
        System.out.println("Duracion del test de busqueda: " + duration / 1000000 + " milisegundos.\n");
        // test de busqueda optima
        startTime = System.nanoTime();
        for (int i = 0; i < chars.length() * chars.length(); i++) {
            vignere.optimalSearch(i);
        }
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("Duracion del test de busqueda optimizada: " + duration + " nanosegundos.");
        System.out.println("Duracion del test de busqueda optimizada: " + duration / 1000000 + " milisegundos.");
    }
}
