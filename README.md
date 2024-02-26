# Simple Banking System

## Overview

This is a basic banking system implementation that allows users to create accounts, log in, make transactions, and transfer funds between accounts. 
The system follows the MVVM (Model View ViewModel) pattern. This application uses Mysql as a server to store data.

## Features

1. **Create Account:**
    Allows users to create a new account with the following details:
        - Name
        - Age
        - Initial deposit amount
        - Password
        - Phone number
        - Automatically generates a unique account number.

2. **Sign In:**
    Users can log in with their account number and password to view their account details.

3. **Withdraw:**
    Users can withdraw money from their account by providing account number, password, and the amount to withdraw.

4. **Money Transfer:**
    Allows users to transfer money from one account to another.
    Two options for fund transfer:
        - Provide own account number, password, recipient's account number, and the amount.
        - Provide recipient's account number and the amount (assuming the user has cash on hand).

## Project Structure

src/

|-- model/

|   |-- Account.java 

|   |-- Transaction.java

|-- view/

|   |-- CreateAccountView.java

|   |-- SignInView.java

|   |-- WithdrawView.java

|   |-- MoneyTransferView.java

|-- viewModel/

|   |-- CreateAccountViewModel.java

|   |-- MoneyTransferViewModel.java

|   |-- WithdrawViewModel.java

|-- Repository

|   |-- AccountDto.java
|   |-- Database.java

|-- Main.java

## Technologies Used

- Java
- MVVM Pattern
- SQL

## Contributors

- R Jesvin
