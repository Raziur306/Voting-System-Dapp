package com.eritlab.votingsystem.contract;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import org.web3j.abi.TypeReference;
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
    public static final String BINARY = "60806040526000805460ff191690556002805460ff60a01b1916905534801561002757600080fd5b50600280546001600160a01b03191633179055610d4b806100496000396000f3fe608060405234801561001057600080fd5b50600436106100625760003560e01c8063137967a614610067578063196b2e241461007c5780631f6d52c5146100a55780634c0a6af0146100b857806388feb516146100c0578063fab2f86b146100d3575b600080fd5b61007a610075366004610a50565b6100db565b005b61008f61008a366004610ab4565b61030d565b60405161009c9190610b15565b60405180910390f35b61007a6100b3366004610ab4565b610503565b61007a610604565b61007a6100ce366004610ab4565b6106fc565b61007a6108c6565b6002546001600160a01b0316331461010e5760405162461bcd60e51b815260040161010590610b5b565b60405180910390fd5b81516000036101555760405162461bcd60e51b81526020600482015260136024820152724e616d652043616e277420626520656d70747960681b6044820152606401610105565b805160000361019e5760405162461bcd60e51b815260206004820152601560248201527453796d626f6c2063616e277420626520656d70747960581b6044820152606401610105565b6004816040516101ae9190610b89565b90815260405190819003602001902080546101c890610ba5565b1590506102175760405162461bcd60e51b815260206004820152601e60248201527f546869732053796d626f6c2077617320616c72656164792074616b656e2e00006044820152606401610105565b60005460ff161561027b5760405162461bcd60e51b815260206004820152602860248201527f43616e64696461746520726567697374726174696f6e20776173206e6f74207060448201526737b9b9b4b136329760c11b6064820152608401610105565b600380546001810182556000919091527fc2575a0e9e593c00f959f8c92f12db2869c3395a3b0502d05e2516446f71f85b016102b78282610c2e565b50816004826040516102c99190610b89565b908152604051908190036020019020906102e39082610c2e565b5060006004826040516102f69190610b89565b908152604051908190036020019020600101555050565b60408051808201909152606081526000602082015260008251116103635760405162461bcd60e51b815260206004820152600d60248201526c125b9d985b1a5908125b9c1d5d609a1b6044820152606401610105565b60006004836040516103759190610b89565b908152604051908190036020019020805461038f90610ba5565b9050116103d05760405162461bcd60e51b815260206004820152600f60248201526e139bc8149958dbdc9908119bdd5b99608a1b6044820152606401610105565b60005460ff1615156001146104375760405162461bcd60e51b815260206004820152602760248201527f466f72207265636f726420766f74696e67206d75737420626520737461727465604482015266321037b731b29760c91b6064820152608401610105565b6004826040516104479190610b89565b908152602001604051809103902060405180604001604052908160008201805461047090610ba5565b80601f016020809104026020016040519081016040528092919081815260200182805461049c90610ba5565b80156104e95780601f106104be576101008083540402835291602001916104e9565b820191906000526020600020905b8154815290600101906020018083116104cc57829003601f168201915b505050505081526020016001820154815250509050919050565b600254600160a01b900460ff16151560011461055b5760405162461bcd60e51b81526020600482015260176024820152762b37ba34b733903737ba1039ba30b93a32b2103cb2ba1760491b6044820152606401610105565b60048160405161056b9190610b89565b908152604051908190036020019020805461058590610ba5565b90506000036105ca5760405162461bcd60e51b815260206004820152601160248201527029bcb6b137b6103737ba103337bab7321760791b6044820152606401610105565b60016004826040516105dc9190610b89565b908152602001604051809103902060010160008282546105fc9190610cee565b909155505050565b6002546001600160a01b0316331461062e5760405162461bcd60e51b815260040161010590610b5b565b60035461068d5760405162461bcd60e51b815260206004820152602760248201527f41746c6561737420322063616e646964617465206d757374206265207265676960448201526639ba32b932b21760c91b6064820152608401610105565b600254600160a01b900460ff16156106da5760405162461bcd60e51b815260206004820152601060248201526f20b63932b0b23c9029ba30b93a32b21760811b6044820152606401610105565b6002805460ff60a01b1916600160a01b1790556000805460ff19166001179055565b6002546001600160a01b031633146107265760405162461bcd60e51b815260040161010590610b5b565b6003546107855760405162461bcd60e51b815260206004820152602760248201527f41746c6561737420312063616e646964617465206d757374206265207265676960448201526639ba32b932b21760c91b6064820152608401610105565b80516000036107c75760405162461bcd60e51b815260206004820152600e60248201526d43616e277420626520656d70747960901b6044820152606401610105565b6004816040516107d79190610b89565b90815260405190819003602001902080546107f190610ba5565b905060000361083b5760405162461bcd60e51b815260206004820152601660248201527529bcb6b137b6103737ba103932b3b4b9ba32b932b21760511b6044820152606401610105565b60005460ff161561088e5760405162461bcd60e51b815260206004820152601b60248201527f596f752063616e27742072656d6f76652063616e6469646174652e00000000006044820152606401610105565b60048160405161089e9190610b89565b90815260405190819003602001902060006108b98282610957565b6001820160009055505050565b6002546001600160a01b031633146108f05760405162461bcd60e51b815260040161010590610b5b565b600254600160a01b900460ff1615156001146109485760405162461bcd60e51b81526020600482015260176024820152762b37ba34b733903737ba1039ba30b93a32b2103cb2ba1760491b6044820152606401610105565b6002805460ff60a01b19169055565b50805461096390610ba5565b6000825580601f10610973575050565b601f0160209004906000526020600020908101906109919190610994565b50565b5b808211156109a95760008155600101610995565b5090565b634e487b7160e01b600052604160045260246000fd5b600082601f8301126109d457600080fd5b813567ffffffffffffffff808211156109ef576109ef6109ad565b604051601f8301601f19908116603f01168101908282118183101715610a1757610a176109ad565b81604052838152866020858801011115610a3057600080fd5b836020870160208301376000602085830101528094505050505092915050565b60008060408385031215610a6357600080fd5b823567ffffffffffffffff80821115610a7b57600080fd5b610a87868387016109c3565b93506020850135915080821115610a9d57600080fd5b50610aaa858286016109c3565b9150509250929050565b600060208284031215610ac657600080fd5b813567ffffffffffffffff811115610add57600080fd5b610ae9848285016109c3565b949350505050565b60005b83811015610b0c578181015183820152602001610af4565b50506000910152565b6020815260008251604060208401528051806060850152610b3d816080860160208501610af1565b60209490940151604084015250506080601f909201601f1916010190565b6020808252601490820152732ab730baba3437b934bd32b21020b1b1b2b9b99760611b604082015260600190565b60008251610b9b818460208701610af1565b9190910192915050565b600181811c90821680610bb957607f821691505b602082108103610bd957634e487b7160e01b600052602260045260246000fd5b50919050565b601f821115610c2957600081815260208120601f850160051c81016020861015610c065750805b601f850160051c820191505b81811015610c2557828155600101610c12565b5050505b505050565b815167ffffffffffffffff811115610c4857610c486109ad565b610c5c81610c568454610ba5565b84610bdf565b602080601f831160018114610c915760008415610c795750858301515b600019600386901b1c1916600185901b178555610c25565b600085815260208120601f198616915b82811015610cc057888601518255948401946001909101908401610ca1565b5085821015610cde5787850151600019600388901b60f8161c191681555b5050505050600190811b01905550565b80820180821115610d0f57634e487b7160e01b600052601160045260246000fd5b9291505056fea2646970667358221220b85b2301fc3f0925b1857af986ed10edc07fa9d2564f105f905f596a03c97cb164736f6c63430008110033";

    public static final String FUNC_DELETECANDIDATE = "deleteCandidate";

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
