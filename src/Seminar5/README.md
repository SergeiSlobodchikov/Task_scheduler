Этот код включает в себя следующие компоненты:
- `Contact (контакт)`- класс, представляющий контактную информацию человека описывающий контакт (имя, фамилия, номер телефона и email). Он имеет конструктор, который инициализирует поля класса, а также переопределенные методы equals, hashCode и toString.
- `Phonebook (телефонная книга)` - класс который имеет список контактов и объект ContactsFileManager, обеспечивает чтение и запись контактов в файл.
- `PhonebookUI (меню)` - класс, представляет интерфейс пользователя для работы с телефонной книгой.
- `ExplortFile` `ImportFile` - интерфейсы, который позволяет импортировать и экспортировать списки в файлы.
- `ImprtFileTo` `ExportFileTo` - реализуют интерфейсы импорта и експорта файла