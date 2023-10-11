using ClinicService.Controllers;
using ClinicService.Models;
using ClinicService.Models.Requests;
using ClinicService.Services;
using Microsoft.AspNetCore.Mvc;
using Moq;

namespace ClinicServiceTests
{
    public class ClientControllerTests
    {
        private ClientController _clientController;
        private Mock<IClientRepository> _mockClientRepository;

        public ClientControllerTests()
        {
            _mockClientRepository = new Mock<IClientRepository>();
            _clientController = new ClientController(_mockClientRepository.Object);
        }

        [Fact]
        public void GetAllClientsTest()
        {
            // [1.1] Подготовка данных

            // [1.2] 
            List<Client> clients = new List<Client>();
            clients.Add(new Client());
            clients.Add(new Client());
            clients.Add(new Client());
            _mockClientRepository.Setup(repository => repository.GetAll()).Returns(clients);

            // [2] Исполнение тестируемого метода
            var operationResult = _clientController.GetAll();

            // [3] Подготовка эталонного результата и его сравнение c полученным:
            // - вернулся результат Ок,
            // - в качестве параметра вернулся список клиентов,
            // - в репозитории вызывался хотя бы раз метод GetAll
            Assert.IsType<OkObjectResult>(operationResult.Result);
            Assert.IsAssignableFrom<List<Client>>(((OkObjectResult)operationResult.Result).Value);

            _mockClientRepository.Verify(repository => repository.GetAll(), Times.AtLeastOnce);
        }

        [Fact]
        public void GetClientByIdTest()
        {
            // [1.1] Подготовка данных

            // [1.2] 
            List<Client> clients = new List<Client>();
            clients.Add(new Client());
            clients.Add(new Client());
            clients.Add(new Client());
            int testId = 2;
            _mockClientRepository.Setup(repository => repository.GetById(testId)).Returns(clients[testId]);

            // [2] Исполнение тестируемого метода
            var operationResult = _clientController.GetById(testId);

            // [3] Подготовка эталонного результата и его сравнение c полученным:
            // - вернулся результат Ок,
            // - в качестве параметра вернулся клиент,
            // - вернулся именно тот клиент, эквивалентный содержащемуся в списке под этим testId
            // - в репозитории вызывался хотя бы раз метод GetById
            Assert.IsType<OkObjectResult>(operationResult.Result);
            Assert.IsAssignableFrom<Client>(((OkObjectResult)operationResult.Result).Value);
            Assert.Equal(clients[testId], ((OkObjectResult)operationResult.Result).Value);
            _mockClientRepository.Verify(repository => repository.GetById(testId), Times.AtLeastOnce);
        }

        [Fact]
        public void DeleteClientByIdTest()
        {
            // [1.1] Подготовка данных

            // [1.2] 
            List<Client> clients = new List<Client>();
            clients.Add(new Client());
            clients.Add(new Client());
            clients.Add(new Client());
            int sizeBefore = clients.Count;
            int testId = 2;
            _mockClientRepository.Setup(repository => repository.Delete(testId)).Returns(clients.Count).Verifiable();

            // [2] Исполнение тестируемого метода
            var operationResult = _clientController.Delete(testId);

            // [3] Подготовка эталонного результата и его сравнение c полученным:
            // - вернулся результат Ок,
            // - удален именно тот клиент с testId
            // - в репозитории вызывался хотя бы раз метод Delete
            Assert.IsType<OkObjectResult>(operationResult.Result);
            Assert.IsAssignableFrom<int>(((OkObjectResult)operationResult.Result).Value);
           
            _mockClientRepository.Verify(repository => repository.Delete(testId), Times.AtLeastOnce);
        }

        public static readonly object[][] CorrectCreateClientDate =
        {
            new object[] { new DateTime(1990, 10, 20), "1111 123456", "Иванов", "Иван", "Иванович"},
            new object[] { new DateTime(1991, 11, 21), "2222 123456", "Петров", "Петр", "Петрович"},
            new object[] { new DateTime(1992, 12, 22), "3333 123456", "Сергеев", "Сергей", "Сергеевич"}
        };

        [Theory]
        [MemberData(nameof(CorrectCreateClientDate))]
        public void CreateClientTest(DateTime birthday, string document, string surName, string firstName, string patronymic)
        {
            // [1.1] Подготовка данных
            _mockClientRepository.Setup(repository => repository.Create(It.IsNotNull<Client>())).Returns(1).Verifiable();

            // [2] Исполнение тестируемого метода
            var operationResult = _clientController.Create(new CreateClientRequest
            {
                Birthday = birthday,
                Document = document,
                SurName = surName,
                FirstName = firstName,
                Patronymic = patronymic
            });

            // [3] Подготовка эталонного результата и его сравнение c полученным:
            // - вернулся результат Ок,
            // - в качестве параметра вернулся список клиентов,
            // - в репозитории вызывался хотя бы раз метод GetAll
            Assert.IsType<OkObjectResult>(operationResult.Result);
            Assert.IsAssignableFrom<int>(((OkObjectResult)operationResult.Result).Value);
            _mockClientRepository.Verify(repository => repository.Create(It.IsNotNull<Client>()), Times.AtLeastOnce);
        }

        public static object[][] CorrectUpdateClientDate =
        {
            new object[] { 0, new DateTime(1990, 10, 20), "1111 123456", "Иванов", "Иван", "Иванович"},
            new object[] { 1, new DateTime(1991, 11, 21), "2222 123456", "Петров", "Петр", "Петрович"},
            new object[] { 2, new DateTime(1992, 12, 22), "3333 123456", "Сергеев", "Сергей", "Сергеевич"}
        };

        [Theory]
        [MemberData(nameof(CorrectUpdateClientDate))]
        public void UpdateClientTest(int id, DateTime birthday, string document, string surName, string firstName, string patronymic)
        {
            // [1.1] Подготовка данных
            Client client = new Client();
            client.ClientId = 1;
            client.Birthday = new DateTime(1993, 12, 22);
            client.Document = "4444 123456";
            client.SurName = "Петровский";
            client.FirstName = "Пётр";
            client.Patronymic = "Петрович";
            _mockClientRepository.Setup(repository => repository.Create(It.IsNotNull<Client>())).Returns(1);
            _clientController.Create(new CreateClientRequest
            {
                Birthday = birthday,
                Document = document,
                SurName = surName,
                FirstName = firstName,
                Patronymic = patronymic
            });

            _mockClientRepository.Setup(repository => repository.Update(client)).Returns(1).Verifiable();

            // [2] Исполнение тестируемого метода
            var operationResult = _clientController.Update(new UpdateClientRequest
            {
                ClientId = client.ClientId,
                Birthday = client.Birthday,
                Document = client.Document,
                SurName = client.SurName,
                FirstName = client.FirstName,
                Patronymic = client.Patronymic
            });

            // [3] Подготовка эталонного результата и его сравнение c полученным:
            // - вернулся результат Ок,
            // - в качестве параметра вернулся список клиентов,
            // - в репозитории вызывался хотя бы раз метод Update
            Assert.IsType<OkObjectResult>(operationResult.Result);
            Assert.IsAssignableFrom<int>(((OkObjectResult)operationResult.Result).Value);
           
            _mockClientRepository.Verify(repository => repository.Update(It.IsNotNull<Client>()), Times.AtLeastOnce);
        }

    }
}