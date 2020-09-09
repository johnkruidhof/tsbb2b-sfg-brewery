package guru.springframework.brewery.web.mappers;

import guru.springframework.brewery.domain.BeerOrder;
import guru.springframework.brewery.domain.BeerOrderLine;
import guru.springframework.brewery.web.model.BeerOrderDto;
import guru.springframework.brewery.web.model.BeerOrderLineDto;
import guru.springframework.brewery.web.model.OrderStatusEnum;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-09-09T15:10:34+0200",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 14.0.1 (N/A)"
)
@Component
public class BeerOrderMapperImpl implements BeerOrderMapper {

    @Autowired
    private DateMapper dateMapper;

    @Override
    public BeerOrderDto beerOrderToDto(BeerOrder beerOrder) {
        if ( beerOrder == null ) {
            return null;
        }

        BeerOrderDto beerOrderDto = new BeerOrderDto();

        beerOrderDto.setId( beerOrder.getId() );
        if ( beerOrder.getVersion() != null ) {
            beerOrderDto.setVersion( beerOrder.getVersion().intValue() );
        }
        beerOrderDto.setCreatedDate( dateMapper.asOffsetDateTime( beerOrder.getCreatedDate() ) );
        beerOrderDto.setLastModifiedDate( dateMapper.asOffsetDateTime( beerOrder.getLastModifiedDate() ) );
        beerOrderDto.setCustomerRef( beerOrder.getCustomerRef() );
        beerOrderDto.setBeerOrderLines( beerOrderLineSetToBeerOrderLineDtoList( beerOrder.getBeerOrderLines() ) );
        beerOrderDto.setOrderStatus( orderStatusEnumToOrderStatusEnum( beerOrder.getOrderStatus() ) );
        beerOrderDto.setOrderStatusCallbackUrl( beerOrder.getOrderStatusCallbackUrl() );

        return beerOrderDto;
    }

    @Override
    public BeerOrder dtoToBeerOrder(BeerOrderDto dto) {
        if ( dto == null ) {
            return null;
        }

        BeerOrder beerOrder = new BeerOrder();

        beerOrder.setId( dto.getId() );
        if ( dto.getVersion() != null ) {
            beerOrder.setVersion( dto.getVersion().longValue() );
        }
        beerOrder.setCreatedDate( dateMapper.asTimestamp( dto.getCreatedDate() ) );
        beerOrder.setLastModifiedDate( dateMapper.asTimestamp( dto.getLastModifiedDate() ) );
        beerOrder.setCustomerRef( dto.getCustomerRef() );
        beerOrder.setBeerOrderLines( beerOrderLineDtoListToBeerOrderLineSet( dto.getBeerOrderLines() ) );
        beerOrder.setOrderStatus( orderStatusEnumToOrderStatusEnum1( dto.getOrderStatus() ) );
        beerOrder.setOrderStatusCallbackUrl( dto.getOrderStatusCallbackUrl() );

        return beerOrder;
    }

    @Override
    public BeerOrderLineDto beerOrderLineToDto(BeerOrderLine line) {
        if ( line == null ) {
            return null;
        }

        BeerOrderLineDto beerOrderLineDto = new BeerOrderLineDto();

        beerOrderLineDto.setId( line.getId() );
        if ( line.getVersion() != null ) {
            beerOrderLineDto.setVersion( line.getVersion().intValue() );
        }
        beerOrderLineDto.setCreatedDate( dateMapper.asOffsetDateTime( line.getCreatedDate() ) );
        beerOrderLineDto.setLastModifiedDate( dateMapper.asOffsetDateTime( line.getLastModifiedDate() ) );
        beerOrderLineDto.setOrderQuantity( line.getOrderQuantity() );

        return beerOrderLineDto;
    }

    protected List<BeerOrderLineDto> beerOrderLineSetToBeerOrderLineDtoList(Set<BeerOrderLine> set) {
        if ( set == null ) {
            return null;
        }

        List<BeerOrderLineDto> list = new ArrayList<BeerOrderLineDto>( set.size() );
        for ( BeerOrderLine beerOrderLine : set ) {
            list.add( beerOrderLineToDto( beerOrderLine ) );
        }

        return list;
    }

    protected OrderStatusEnum orderStatusEnumToOrderStatusEnum(guru.springframework.brewery.domain.OrderStatusEnum orderStatusEnum) {
        if ( orderStatusEnum == null ) {
            return null;
        }

        OrderStatusEnum orderStatusEnum1;

        switch ( orderStatusEnum ) {
            case NEW: orderStatusEnum1 = OrderStatusEnum.NEW;
            break;
            case READY: orderStatusEnum1 = OrderStatusEnum.READY;
            break;
            case PICKED_UP: orderStatusEnum1 = OrderStatusEnum.PICKED_UP;
            break;
            default: throw new IllegalArgumentException( "Unexpected enum constant: " + orderStatusEnum );
        }

        return orderStatusEnum1;
    }

    protected Set<BeerOrderLine> beerOrderLineDtoListToBeerOrderLineSet(List<BeerOrderLineDto> list) {
        if ( list == null ) {
            return null;
        }

        Set<BeerOrderLine> set = new HashSet<BeerOrderLine>( Math.max( (int) ( list.size() / .75f ) + 1, 16 ) );
        for ( BeerOrderLineDto beerOrderLineDto : list ) {
            set.add( dtoToBeerOrder( beerOrderLineDto ) );
        }

        return set;
    }

    protected guru.springframework.brewery.domain.OrderStatusEnum orderStatusEnumToOrderStatusEnum1(OrderStatusEnum orderStatusEnum) {
        if ( orderStatusEnum == null ) {
            return null;
        }

        guru.springframework.brewery.domain.OrderStatusEnum orderStatusEnum1;

        switch ( orderStatusEnum ) {
            case NEW: orderStatusEnum1 = guru.springframework.brewery.domain.OrderStatusEnum.NEW;
            break;
            case READY: orderStatusEnum1 = guru.springframework.brewery.domain.OrderStatusEnum.READY;
            break;
            case PICKED_UP: orderStatusEnum1 = guru.springframework.brewery.domain.OrderStatusEnum.PICKED_UP;
            break;
            default: throw new IllegalArgumentException( "Unexpected enum constant: " + orderStatusEnum );
        }

        return orderStatusEnum1;
    }
}
