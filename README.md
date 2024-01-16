# @inspire-labs-tms-tech/inspire-tms-open-api

An OpenAPI client for Typescript.

## Quick Start

- Hosted Instance:

```typescript
import { InspireTMS } from "@inspire-labs-tms-tech/inspire-tms-open-api";

// https://{name}.app.inspiretmsconnect.com/api/v1/open-api
const client = new InspireTMS({
  name: "testing" // https://testing.app.inspiretmsconnect.com/api/v1/open-api
});
```

- Local Instance:

```typescript
import { InspireTMS } from "@inspire-labs-tms-tech/inspire-tms-open-api";

const client = new InspireTMS({
  base: "http://localhost:3000/api/v1/open-api"
});
```