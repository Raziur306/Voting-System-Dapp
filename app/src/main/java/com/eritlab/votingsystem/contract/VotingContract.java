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
    public static final String BINARY = "60806040526000805460ff60ff60a81b011916905534801561002057600080fd5b50600080546101003302610100600160a81b0319909116179055610f0a806100496000396000f3fe608060405234801561001057600080fd5b506004361061007d5760003560e01c80635e80a6931161005b5780635e80a693146100c857806388feb516146100dd578063940c84c2146100f0578063fab2f86b1461010357600080fd5b8063137967a614610082578063196b2e24146100975780634c0a6af0146100c0575b600080fd5b610095610090366004610b95565b61010b565b005b6100aa6100a5366004610bf9565b610341565b6040516100b79190610c86565b60405180910390f35b610095610537565b6100d061062d565b6040516100b79190610cb8565b6100956100eb366004610bf9565b610706565b6100956100fe366004610b95565b6108d5565b610095610a06565b60005461010090046001600160a01b031633146101435760405162461bcd60e51b815260040161013a90610d1a565b60405180910390fd5b815160000361018a5760405162461bcd60e51b81526020600482015260136024820152724e616d652043616e277420626520656d70747960681b604482015260640161013a565b80516000036101d35760405162461bcd60e51b815260206004820152601560248201527453796d626f6c2063616e277420626520656d70747960581b604482015260640161013a565b6002816040516101e39190610d48565b90815260405190819003602001902080546101fd90610d64565b15905061024c5760405162461bcd60e51b815260206004820152601e60248201527f546869732053796d626f6c2077617320616c72656164792074616b656e2e0000604482015260640161013a565b60005460ff16156102b05760405162461bcd60e51b815260206004820152602860248201527f43616e64696461746520726567697374726174696f6e20776173206e6f74207060448201526737b9b9b4b136329760c11b606482015260840161013a565b6001805480820182556000919091527fb10e2d527612073b26eecdfd717e6a320cf44b4afac2b0732d9fcbe2b7fa0cf6016102eb8282610ded565b50816002826040516102fd9190610d48565b908152604051908190036020019020906103179082610ded565b50600060028260405161032a9190610d48565b908152604051908190036020019020600101555050565b60408051808201909152606081526000602082015260008251116103975760405162461bcd60e51b815260206004820152600d60248201526c125b9d985b1a5908125b9c1d5d609a1b604482015260640161013a565b60006002836040516103a99190610d48565b90815260405190819003602001902080546103c390610d64565b9050116104045760405162461bcd60e51b815260206004820152600f60248201526e139bc8149958dbdc9908119bdd5b99608a1b604482015260640161013a565b60005460ff16151560011461046b5760405162461bcd60e51b815260206004820152602760248201527f466f72207265636f726420766f74696e67206d75737420626520737461727465604482015266321037b731b29760c91b606482015260840161013a565b60028260405161047b9190610d48565b90815260200160405180910390206040518060400160405290816000820180546104a490610d64565b80601f01602080910402602001604051908101604052809291908181526020018280546104d090610d64565b801561051d5780601f106104f25761010080835404028352916020019161051d565b820191906000526020600020905b81548152906001019060200180831161050057829003601f168201915b505050505081526020016001820154815250509050919050565b60005461010090046001600160a01b031633146105665760405162461bcd60e51b815260040161013a90610d1a565b6001546105c55760405162461bcd60e51b815260206004820152602760248201527f41746c6561737420322063616e646964617465206d757374206265207265676960448201526639ba32b932b21760c91b606482015260840161013a565b600054600160a81b900460ff16156106125760405162461bcd60e51b815260206004820152601060248201526f20b63932b0b23c9029ba30b93a32b21760811b604482015260640161013a565b6000805460ff60ff60a81b0119166001600160a81b01179055565b60606001805480602002602001604051908101604052809291908181526020016000905b828210156106fd57838290600052602060002001805461067090610d64565b80601f016020809104026020016040519081016040528092919081815260200182805461069c90610d64565b80156106e95780601f106106be576101008083540402835291602001916106e9565b820191906000526020600020905b8154815290600101906020018083116106cc57829003601f168201915b505050505081526020019060010190610651565b50505050905090565b60005461010090046001600160a01b031633146107355760405162461bcd60e51b815260040161013a90610d1a565b6001546107945760405162461bcd60e51b815260206004820152602760248201527f41746c6561737420312063616e646964617465206d757374206265207265676960448201526639ba32b932b21760c91b606482015260840161013a565b80516000036107d65760405162461bcd60e51b815260206004820152600e60248201526d43616e277420626520656d70747960901b604482015260640161013a565b6002816040516107e69190610d48565b908152604051908190036020019020805461080090610d64565b905060000361084a5760405162461bcd60e51b815260206004820152601660248201527529bcb6b137b6103737ba103932b3b4b9ba32b932b21760511b604482015260640161013a565b60005460ff161561089d5760405162461bcd60e51b815260206004820152601b60248201527f596f752063616e27742072656d6f76652063616e6469646174652e0000000000604482015260640161013a565b6002816040516108ad9190610d48565b90815260405190819003602001902060006108c88282610a9c565b6001820160009055505050565b600054600160a81b900460ff16151560011461092d5760405162461bcd60e51b81526020600482015260176024820152762b37ba34b733903737ba1039ba30b93a32b2103cb2ba1760491b604482015260640161013a565b60038160405161093d9190610d48565b9081526040519081900360200190205460ff1615156001036109975760405162461bcd60e51b81526020600482015260136024820152722cb7ba9031b0b7103b37ba329037b731b2971760691b604482015260640161013a565b60016002836040516109a99190610d48565b908152602001604051809103902060010160008282546109c99190610ead565b9250508190555060016003826040516109e29190610d48565b908152604051908190036020019020805491151560ff199092169190911790555050565b60005461010090046001600160a01b03163314610a355760405162461bcd60e51b815260040161013a90610d1a565b600054600160a81b900460ff161515600114610a8d5760405162461bcd60e51b81526020600482015260176024820152762b37ba34b733903737ba1039ba30b93a32b2103cb2ba1760491b604482015260640161013a565b6000805460ff60a81b19169055565b508054610aa890610d64565b6000825580601f10610ab8575050565b601f016020900490600052602060002090810190610ad69190610ad9565b50565b5b80821115610aee5760008155600101610ada565b5090565b634e487b7160e01b600052604160045260246000fd5b600082601f830112610b1957600080fd5b813567ffffffffffffffff80821115610b3457610b34610af2565b604051601f8301601f19908116603f01168101908282118183101715610b5c57610b5c610af2565b81604052838152866020858801011115610b7557600080fd5b836020870160208301376000602085830101528094505050505092915050565b60008060408385031215610ba857600080fd5b823567ffffffffffffffff80821115610bc057600080fd5b610bcc86838701610b08565b93506020850135915080821115610be257600080fd5b50610bef85828601610b08565b9150509250929050565b600060208284031215610c0b57600080fd5b813567ffffffffffffffff811115610c2257600080fd5b610c2e84828501610b08565b949350505050565b60005b83811015610c51578181015183820152602001610c39565b50506000910152565b60008151808452610c72816020860160208601610c36565b601f01601f19169290920160200192915050565b602081526000825160406020840152610ca26060840182610c5a565b9050602084015160408401528091505092915050565b6000602080830181845280855180835260408601915060408160051b870101925083870160005b82811015610d0d57603f19888603018452610cfb858351610c5a565b94509285019290850190600101610cdf565b5092979650505050505050565b6020808252601490820152732ab730baba3437b934bd32b21020b1b1b2b9b99760611b604082015260600190565b60008251610d5a818460208701610c36565b9190910192915050565b600181811c90821680610d7857607f821691505b602082108103610d9857634e487b7160e01b600052602260045260246000fd5b50919050565b601f821115610de857600081815260208120601f850160051c81016020861015610dc55750805b601f850160051c820191505b81811015610de457828155600101610dd1565b5050505b505050565b815167ffffffffffffffff811115610e0757610e07610af2565b610e1b81610e158454610d64565b84610d9e565b602080601f831160018114610e505760008415610e385750858301515b600019600386901b1c1916600185901b178555610de4565b600085815260208120601f198616915b82811015610e7f57888601518255948401946001909101908401610e60565b5085821015610e9d5787850151600019600388901b60f8161c191681555b5050505050600190811b01905550565b80820180821115610ece57634e487b7160e01b600052601160045260246000fd5b9291505056fea2646970667358221220417c23f956d45984459a29847cd954900f8250905a1b6268ed851df872c3d67264736f6c63430008110033";

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

    public RemoteFunctionCall<TransactionReceipt> giveVotes(String symbol, String voterAddress) {
        final Function function = new Function(
                FUNC_GIVEVOTES, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(symbol), 
                new org.web3j.abi.datatypes.Utf8String(voterAddress)), 
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
