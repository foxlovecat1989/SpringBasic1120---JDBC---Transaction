# SpringBasic1120---JDBC---Transaction
# Transaction - Resposity -> Service -> Controller
# 交易屬性 @Transactional(propagation = Propagation.REQUIRED, 
            timeout = 2,
            rollbackFor = {InsufficientAmountException.class})
            
# 隔離層級 - 防止 # lost update # unrepeatable read # dirty read # phantom read
# 講解 rollbackFor = {InsufficientAmountException.class}
