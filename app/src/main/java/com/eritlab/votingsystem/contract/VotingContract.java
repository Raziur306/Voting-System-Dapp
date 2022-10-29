package com.eritlab.votingsystem.contract;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.DynamicArray;
import org.web3j.abi.datatypes.DynamicStruct;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 1.4.2.
 */
@SuppressWarnings("rawtypes")
public class VotingContract extends Contract {
    public static final String BINARY = "60806040526000805460ff191690556002805460ff60a01b1916905534801561002757600080fd5b50600280546001600160a01b03191633179055610ece806100496000396000f3fe608060405234801561001057600080fd5b506004361061007d5760003560e01c80634c0a6af01161005b5780634c0a6af0146100d35780635e80a693146100db57806388feb516146100f0578063fab2f86b1461010357600080fd5b8063137967a614610082578063196b2e24146100975780631f6d52c5146100c0575b600080fd5b610095610090366004610b59565b61010b565b005b6100aa6100a5366004610bbd565b61033d565b6040516100b79190610c4a565b60405180910390f35b6100956100ce366004610bbd565b610533565b610095610634565b6100e361072c565b6040516100b79190610c7c565b6100956100fe366004610bbd565b610805565b6100956109cf565b6002546001600160a01b0316331461013e5760405162461bcd60e51b815260040161013590610cde565b60405180910390fd5b81516000036101855760405162461bcd60e51b81526020600482015260136024820152724e616d652043616e277420626520656d70747960681b6044820152606401610135565b80516000036101ce5760405162461bcd60e51b815260206004820152601560248201527453796d626f6c2063616e277420626520656d70747960581b6044820152606401610135565b6004816040516101de9190610d0c565b90815260405190819003602001902080546101f890610d28565b1590506102475760405162461bcd60e51b815260206004820152601e60248201527f546869732053796d626f6c2077617320616c72656164792074616b656e2e00006044820152606401610135565b60005460ff16156102ab5760405162461bcd60e51b815260206004820152602860248201527f43616e64696461746520726567697374726174696f6e20776173206e6f74207060448201526737b9b9b4b136329760c11b6064820152608401610135565b600380546001810182556000919091527fc2575a0e9e593c00f959f8c92f12db2869c3395a3b0502d05e2516446f71f85b016102e78282610db1565b50816004826040516102f99190610d0c565b908152604051908190036020019020906103139082610db1565b5060006004826040516103269190610d0c565b908152604051908190036020019020600101555050565b60408051808201909152606081526000602082015260008251116103935760405162461bcd60e51b815260206004820152600d60248201526c125b9d985b1a5908125b9c1d5d609a1b6044820152606401610135565b60006004836040516103a59190610d0c565b90815260405190819003602001902080546103bf90610d28565b9050116104005760405162461bcd60e51b815260206004820152600f60248201526e139bc8149958dbdc9908119bdd5b99608a1b6044820152606401610135565b60005460ff1615156001146104675760405162461bcd60e51b815260206004820152602760248201527f466f72207265636f726420766f74696e67206d75737420626520737461727465604482015266321037b731b29760c91b6064820152608401610135565b6004826040516104779190610d0c565b90815260200160405180910390206040518060400160405290816000820180546104a090610d28565b80601f01602080910402602001604051908101604052809291908181526020018280546104cc90610d28565b80156105195780601f106104ee57610100808354040283529160200191610519565b820191906000526020600020905b8154815290600101906020018083116104fc57829003601f168201915b505050505081526020016001820154815250509050919050565b600254600160a01b900460ff16151560011461058b5760405162461bcd60e51b81526020600482015260176024820152762b37ba34b733903737ba1039ba30b93a32b2103cb2ba1760491b6044820152606401610135565b60048160405161059b9190610d0c565b90815260405190819003602001902080546105b590610d28565b90506000036105fa5760405162461bcd60e51b815260206004820152601160248201527029bcb6b137b6103737ba103337bab7321760791b6044820152606401610135565b600160048260405161060c9190610d0c565b9081526020016040518091039020600101600082825461062c9190610e71565b909155505050565b6002546001600160a01b0316331461065e5760405162461bcd60e51b815260040161013590610cde565b6003546106bd5760405162461bcd60e51b815260206004820152602760248201527f41746c6561737420322063616e646964617465206d757374206265207265676960448201526639ba32b932b21760c91b6064820152608401610135565b600254600160a01b900460ff161561070a5760405162461bcd60e51b815260206004820152601060248201526f20b63932b0b23c9029ba30b93a32b21760811b6044820152606401610135565b6002805460ff60a01b1916600160a01b1790556000805460ff19166001179055565b60606003805480602002602001604051908101604052809291908181526020016000905b828210156107fc57838290600052602060002001805461076f90610d28565b80601f016020809104026020016040519081016040528092919081815260200182805461079b90610d28565b80156107e85780601f106107bd576101008083540402835291602001916107e8565b820191906000526020600020905b8154815290600101906020018083116107cb57829003601f168201915b505050505081526020019060010190610750565b50505050905090565b6002546001600160a01b0316331461082f5760405162461bcd60e51b815260040161013590610cde565b60035461088e5760405162461bcd60e51b815260206004820152602760248201527f41746c6561737420312063616e646964617465206d757374206265207265676960448201526639ba32b932b21760c91b6064820152608401610135565b80516000036108d05760405162461bcd60e51b815260206004820152600e60248201526d43616e277420626520656d70747960901b6044820152606401610135565b6004816040516108e09190610d0c565b90815260405190819003602001902080546108fa90610d28565b90506000036109445760405162461bcd60e51b815260206004820152601660248201527529bcb6b137b6103737ba103932b3b4b9ba32b932b21760511b6044820152606401610135565b60005460ff16156109975760405162461bcd60e51b815260206004820152601b60248201527f596f752063616e27742072656d6f76652063616e6469646174652e00000000006044820152606401610135565b6004816040516109a79190610d0c565b90815260405190819003602001902060006109c28282610a60565b6001820160009055505050565b6002546001600160a01b031633146109f95760405162461bcd60e51b815260040161013590610cde565b600254600160a01b900460ff161515600114610a515760405162461bcd60e51b81526020600482015260176024820152762b37ba34b733903737ba1039ba30b93a32b2103cb2ba1760491b6044820152606401610135565b6002805460ff60a01b19169055565b508054610a6c90610d28565b6000825580601f10610a7c575050565b601f016020900490600052602060002090810190610a9a9190610a9d565b50565b5b80821115610ab25760008155600101610a9e565b5090565b634e487b7160e01b600052604160045260246000fd5b600082601f830112610add57600080fd5b813567ffffffffffffffff80821115610af857610af8610ab6565b604051601f8301601f19908116603f01168101908282118183101715610b2057610b20610ab6565b81604052838152866020858801011115610b3957600080fd5b836020870160208301376000602085830101528094505050505092915050565b60008060408385031215610b6c57600080fd5b823567ffffffffffffffff80821115610b8457600080fd5b610b9086838701610acc565b93506020850135915080821115610ba657600080fd5b50610bb385828601610acc565b9150509250929050565b600060208284031215610bcf57600080fd5b813567ffffffffffffffff811115610be657600080fd5b610bf284828501610acc565b949350505050565b60005b83811015610c15578181015183820152602001610bfd565b50506000910152565b60008151808452610c36816020860160208601610bfa565b601f01601f19169290920160200192915050565b602081526000825160406020840152610c666060840182610c1e565b9050602084015160408401528091505092915050565b6000602080830181845280855180835260408601915060408160051b870101925083870160005b82811015610cd157603f19888603018452610cbf858351610c1e565b94509285019290850190600101610ca3565b5092979650505050505050565b6020808252601490820152732ab730baba3437b934bd32b21020b1b1b2b9b99760611b604082015260600190565b60008251610d1e818460208701610bfa565b9190910192915050565b600181811c90821680610d3c57607f821691505b602082108103610d5c57634e487b7160e01b600052602260045260246000fd5b50919050565b601f821115610dac57600081815260208120601f850160051c81016020861015610d895750805b601f850160051c820191505b81811015610da857828155600101610d95565b5050505b505050565b815167ffffffffffffffff811115610dcb57610dcb610ab6565b610ddf81610dd98454610d28565b84610d62565b602080601f831160018114610e145760008415610dfc5750858301515b600019600386901b1c1916600185901b178555610da8565b600085815260208120601f198616915b82811015610e4357888601518255948401946001909101908401610e24565b5085821015610e615787850151600019600388901b60f8161c191681555b5050505050600190811b01905550565b80820180821115610e9257634e487b7160e01b600052601160045260246000fd5b9291505056fea2646970667358221220d4daaacd1a051f817ee4c35f3bb0c7b2948996b454a0295b7f1753b6faea212d64736f6c63430008110033";

    public static final String FUNC_DELETECANDIDATE = "deleteCandidate";

    public static final String FUNC_GETSYMBOLLIST = "getSymbolList";

    public static final String FUNC_GIVEVOTES = "giveVotes";

    public static final String FUNC_REGISTRATIONFORCANDIDATE = "registrationForCandidate";

    public static final String FUNC_STARTVOTE = "startVote";

    public static final String FUNC_STOPVOTING = "stopVoting";

    public static final String FUNC_VOTECOUNTSTATUS = "voteCountStatus";

    @Deprecated
    protected VotingContract(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected VotingContract(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected VotingContract(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected VotingContract(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteFunctionCall<TransactionReceipt> deleteCandidate(String symbol) {
        final Function function = new Function(
                FUNC_DELETECANDIDATE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(symbol)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<List> getSymbolList() {
        final Function function = new Function(FUNC_GETSYMBOLLIST, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<DynamicArray<Utf8String>>() {}));
        return new RemoteFunctionCall<List>(function,
                new Callable<List>() {
                    @Override
                    @SuppressWarnings("unchecked")
                    public List call() throws Exception {
                        List<Type> result = (List<Type>) executeCallSingleValueReturn(function, List.class);
                        return convertToNative(result);
                    }
                });
    }

    public RemoteFunctionCall<TransactionReceipt> giveVotes(String symbol) {
        final Function function = new Function(
                FUNC_GIVEVOTES, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(symbol)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> registrationForCandidate(String name, String symbol) {
        final Function function = new Function(
                FUNC_REGISTRATIONFORCANDIDATE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(name), 
                new org.web3j.abi.datatypes.Utf8String(symbol)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> startVote() {
        final Function function = new Function(
                FUNC_STARTVOTE, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> stopVoting() {
        final Function function = new Function(
                FUNC_STOPVOTING, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<candidate> voteCountStatus(String symbol) {
        final Function function = new Function(FUNC_VOTECOUNTSTATUS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(symbol)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<candidate>() {}));
        return executeRemoteCallSingleValueReturn(function, candidate.class);
    }

    @Deprecated
    public static VotingContract load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new VotingContract(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static VotingContract load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new VotingContract(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static VotingContract load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new VotingContract(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static VotingContract load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new VotingContract(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<VotingContract> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(VotingContract.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    public static RemoteCall<VotingContract> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(VotingContract.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<VotingContract> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(VotingContract.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<VotingContract> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(VotingContract.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    public static class candidate extends DynamicStruct {
        public String name;

        public BigInteger voteCount;

        public candidate(String name, BigInteger voteCount) {
            super(new org.web3j.abi.datatypes.Utf8String(name), 
                    new org.web3j.abi.datatypes.generated.Uint256(voteCount));
            this.name = name;
            this.voteCount = voteCount;
        }

        public candidate(Utf8String name, Uint256 voteCount) {
            super(name, voteCount);
            this.name = name.getValue();
            this.voteCount = voteCount.getValue();
        }
    }
}
