package com.akkulov.dmdev.deadlock;

public class AccountThread extends Thread {

  private final Account accountFrom;
  private final Account accountTo;

  public AccountThread(Account accountFrom, Account accountTo) {
    this.accountFrom = accountFrom;
    this.accountTo = accountTo;
  }

  @Override
  public void run() {

    for (int i = 0; i < 2000; i++) {
      try {
        lockAccounts();
        accountFrom.subtractCash(10);
        accountTo.addCash(10);
      } finally {
        accountFrom.getLock().unlock();
        accountTo.getLock().unlock();
      }
    }
  }

  public void lockAccounts() {
    while (true) {
      boolean accountFromLock = accountFrom.getLock().tryLock();
      boolean accountToLock = accountTo.getLock().tryLock();

      if (accountFromLock && accountToLock) {
        break;
      }

      if (accountFromLock) {
        accountFrom.getLock().unlock();
      }

      if (accountToLock) {
        accountTo.getLock().unlock();
      }
    }
  }
}
