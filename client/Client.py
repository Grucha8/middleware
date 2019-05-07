import sys, Ice
import Bank

# pesel: (password, standard/premium)
registered_accounts = dict()

addres_to_connect = 'tcp -h localhost -p 10000:udp -h localhost -p 10000 '
try:
    communicator = Ice.initialize(sys.argv)
except:
    raise RuntimeError("Couldn't initialize connection to bank")


def register():
    base = communicator.stringToProxy(
        "registration/registration:" + addres_to_connect)
    register = Bank.BankOperationsPrx.checkedCast(base)
    if not register:
        raise RuntimeError("Invalid proxy")

    firstName = input("Enter your first name: ")
    lastName = input("Enter your last name: ")
    pesel = input("Enter your pesel: ")
    try:
        monthly_income = int(input("Enter yout monthly income: "))
    except:
        print("Monthly income must be a number")
        return

    try:
        password, account_type = register.register(firstName, lastName, pesel, monthly_income).split("-")
        registered_accounts[pesel] = (password, account_type)
        print("Your password is: " + password + "\nAccount type: " + account_type)
    except:
        print("Wrong pesel")


def login():
    pesel = input("Enter pesel: ")
    password = input("Enter password: ")

    base = communicator.stringToProxy(
        "registration/registration:" + addres_to_connect)
    login = Bank.BankOperationsPrx.checkedCast(base)
    if not register:
        raise RuntimeError("Invalid proxy")
    try:
        acc_type = login.login(pesel, {"password": password})
        if acc_type:
            registered_accounts[pesel] = (password, acc_type)
        else:
            print("Account doesn't exists")
    except:
        print("Wrong pesel")


def handle_premium(pesel, password):
    base = communicator.stringToProxy(f"premium/{pesel}:" + addres_to_connect)
    account = Bank.PremiumAccountPrx.checkedCast(base)
    if not account:
        raise RuntimeError("Invalid proxy for premium account")

    while True:
        decision = input("(balance | credit <value> <currency> <for how long>| exit): ")
        if decision == "balance":
            print(account.getAccountBalance({"password": password}))
        elif decision.split(" ")[0] == "credit":
            value = int(decision.split(" ")[1])
            timeToPayOff = int(decision.split(" ")[3])

            v = account.tryToGetCredit(decision.split(" ")[2], value, timeToPayOff, {"password": password})
            print(f"{v.foreignCurrency} - {v.nativeCurrency}")
            pass
        elif decision == "exit":
            return
        else:
            print("Wrong option")


def handle_standard(pesel, password):
    base = communicator.stringToProxy(f"standard/{pesel}:" + addres_to_connect)
    account = Bank.StandardAccountPrx.checkedCast(base)
    if not account:
        raise RuntimeError("Invalid proxy for standard account")

    while True:
        decision = input("(balance | exit): ")
        if decision == "balance":
            print(account.getAccountBalance({"password": password}))
        elif decision == "exit":
            return
        else:
            print("Wrong option")


def handle_account(account):
    if account[1][1] == "premium":
        handle_premium(account[0], account[1][0])
    else:
        handle_standard(account[0], account[1][0])


def account():
    accounts = list()

    for acc, i in zip(registered_accounts.items(), range(len(registered_accounts))):
        print(str(i) + ": " + acc[0] + " - " + acc[1][1])
        accounts.append((i, acc))

    while True:
        acc_nr = int(input("Chose account: "))
        if 0 <= acc_nr < len(accounts):
            handle_account(accounts[acc_nr][1])
            break
        else:
            print("Value out of range")


def loop():
    while True:
        decision = input("(register | login | account | exit)\nWhat do you want to do: ")
        if decision == "register":
            register()
        elif decision == "login":
            login()
        elif decision == "account":
            account()
        elif decision == "exit":
            return
        else:
            print("Wrong option")


if __name__ == '__main__':
    loop()
